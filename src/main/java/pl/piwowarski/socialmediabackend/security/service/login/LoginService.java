package pl.piwowarski.socialmediabackend.security.service.login;

import org.springframework.security.web.authentication.logout.LogoutHandler;
import pl.piwowarski.socialmediabackend.dto.user.LoginResponse;
import pl.piwowarski.socialmediabackend.dto.user.LoginUserDto;

public interface LoginService {

    LoginResponse authenticate(LoginUserDto input);
}
