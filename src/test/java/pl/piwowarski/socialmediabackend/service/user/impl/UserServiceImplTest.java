package pl.piwowarski.socialmediabackend.service.user.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.piwowarski.socialmediabackend.dto.user.AddUserDto;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.mapper.UserMapper;
import pl.piwowarski.socialmediabackend.provider.TestUserDataProvider;
import pl.piwowarski.socialmediabackend.repository.UserRepository;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.Optional;

public class UserServiceImplTest {

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final PasswordEncoder passwordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
    private final UserService userService = new UserServiceImpl(userRepository, passwordEncoder);
    private final AddUserDto addUserDto1 = TestUserDataProvider.addUserDto1;
    private final User user1 = TestUserDataProvider.user1;
    private final User user2 = TestUserDataProvider.user2;

    @Test
    public void addUserTest() {
        Mockito.when(userRepository.findUserByEmail(addUserDto1.getEmail())).thenReturn(Optional.empty());
        Mockito.when(passwordEncoder.encode(addUserDto1.getPassword()))
                .thenReturn("$2a$10$XHEl4ITYK7X72RnHRmxaHuwFYO1UWA8Z9hEgW.7KPXzWvbuU6K5qy");
        Mockito.when(userRepository.save(user1)).thenReturn(user2);

        try(var mock = Mockito.mockStatic(UserMapper.class)) {
            Mockito.when(UserMapper.map(addUserDto1, passwordEncoder)).thenReturn(user1);

            Assertions.assertEquals(1L, userService.addUser(TestUserDataProvider.addUserDto1));
        }
    }
}
