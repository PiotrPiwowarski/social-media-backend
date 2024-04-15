package pl.piwowarski.socialmediabackend.service.user;

import pl.piwowarski.socialmediabackend.dto.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.GetUserDto;

import java.util.List;

public interface UserService {

    long addUser(AddUserDto addUserDto);
    GetUserDto getUser(long id);
    List<GetUserDto> getAllUsers();
    void deleteUser(long id);
}
