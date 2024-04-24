package pl.piwowarski.socialmediabackend.security.service.login.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.user.LoginResponse;
import pl.piwowarski.socialmediabackend.dto.user.LoginUserDto;
import pl.piwowarski.socialmediabackend.entity.AuthenticationToken;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.exception.NoUsersWithSuchEmail;
import pl.piwowarski.socialmediabackend.repository.AuthenticationTokenRepository;
import pl.piwowarski.socialmediabackend.repository.UserRepository;
import pl.piwowarski.socialmediabackend.security.service.login.LoginService;
import pl.piwowarski.socialmediabackend.security.service.jwt.JwtService;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AuthenticationTokenRepository authenticationTokenRepository;
    private final UserRepository userRepository;

    @Override
    public LoginResponse authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        User user =  userRepository.findUserByEmail(input.getEmail())
                .orElseThrow(() -> new NoUsersWithSuchEmail("Brak użytkowników o podanym emailu"));

        authenticationTokenRepository.deleteByUserId(user.getId());

        String jwtToken = jwtService.generateToken(user);
        authenticationTokenRepository.save(AuthenticationToken.builder().token(jwtToken).user(user).build());

        return LoginResponse.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();
    }
}
