package pl.piwowarski.socialmediabackend.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.user.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;
import pl.piwowarski.socialmediabackend.dto.user.LoginResponse;
import pl.piwowarski.socialmediabackend.dto.user.LoginUserDto;
import pl.piwowarski.socialmediabackend.entity.AuthenticationToken;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.exception.NoUsersWithSuchEmail;
import pl.piwowarski.socialmediabackend.exception.NoUsersWithSuchIdException;
import pl.piwowarski.socialmediabackend.exception.UserAlreadyExistsException;
import pl.piwowarski.socialmediabackend.mapper.UserMapper;
import pl.piwowarski.socialmediabackend.repository.AuthenticationTokenRepository;
import pl.piwowarski.socialmediabackend.repository.UserRepository;
import pl.piwowarski.socialmediabackend.security.service.jwt.JwtService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AuthenticationTokenRepository authenticationTokenRepository;

    @Override
    public long addUser(AddUserDto addUserDto) {
        Optional<User> optionalUser = userRepository.findUserByEmail(addUserDto.getEmail());
        if(optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("Użytkownik o podanym id już istnieje");
        }
        User user = userRepository.save(UserMapper.map(addUserDto, passwordEncoder));
        return user.getId();
    }

    @Override
    public GetUserDto getUser(long id) {
        Optional<User> user = userRepository.findById(id);
        return UserMapper.map(user.orElseThrow(() -> new NoUsersWithSuchIdException("Brak użytkowników o podanym id")));
    }

    @Override
    public User getEntity(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new NoUsersWithSuchIdException("Brak użytkowników o podanym id"));
    }

    @Override
    public List<GetUserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::map)
                .toList();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

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

        String jwtToken = jwtService.generateToken(user);
        authenticationTokenRepository.save(AuthenticationToken.builder().token(jwtToken).user(user).build());

        return LoginResponse.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();
    }
}
