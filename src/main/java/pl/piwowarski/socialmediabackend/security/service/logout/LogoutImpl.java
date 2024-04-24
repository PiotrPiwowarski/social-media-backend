package pl.piwowarski.socialmediabackend.security.service.logout;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.repository.AuthenticationTokenRepository;

@Service
@RequiredArgsConstructor
public class LogoutImpl implements LogoutHandler {

    private final AuthenticationTokenRepository authenticationTokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        authenticationTokenRepository.deleteByToken(jwt);
    }
}
