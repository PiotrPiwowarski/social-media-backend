package pl.piwowarski.socialmediabackend.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import pl.piwowarski.socialmediabackend.dto.user.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;
import pl.piwowarski.socialmediabackend.dto.user.LoginResponse;
import pl.piwowarski.socialmediabackend.dto.user.LoginUserDto;
import pl.piwowarski.socialmediabackend.entity.User;

import java.util.List;

public interface UserService {

    long addUser(AddUserDto addUserDto);
    GetUserDto getUser(long id);
    User getEntity(long id);
    List<GetUserDto> getAllUsers();
    void deleteUser(long id);
    LoginResponse authenticate(LoginUserDto input);
}
