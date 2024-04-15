package pl.piwowarski.socialmediabackend.service;

import pl.piwowarski.socialmediabackend.dto.AddUserDto;

public interface UserService {

    long addUser(AddUserDto addUserDto);
    void deleteUser(long id);
}
