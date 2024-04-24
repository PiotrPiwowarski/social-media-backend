package pl.piwowarski.socialmediabackend.security.service.login;

import pl.piwowarski.socialmediabackend.dto.user.LoginResponse;
import pl.piwowarski.socialmediabackend.dto.user.LoginUserDto;

public interface LoginService {

    LoginResponse authenticate(LoginUserDto input);
}
