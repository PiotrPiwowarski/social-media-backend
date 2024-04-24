package pl.piwowarski.socialmediabackend.service.user.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.piwowarski.socialmediabackend.dto.user.AddUserDto;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.mapper.UserMapper;
import pl.piwowarski.socialmediabackend.repository.AuthenticationTokenRepository;
import pl.piwowarski.socialmediabackend.repository.UserRepository;
import pl.piwowarski.socialmediabackend.security.service.jwt.JwtService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.Optional;

public class UserServiceImplTest {

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final PasswordEncoder passwordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
    private final AuthenticationManager authenticationManager = Mockito.mock(AuthenticationManager.class);
    private final JwtService jwtService = Mockito.mock(JwtService.class);
    private final AuthenticationTokenRepository authenticationTokenRepository =
            Mockito.mock(AuthenticationTokenRepository.class);
    private final User user1 = User.builder()
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("$2a$10$XHEl4ITYK7X72RnHRmxaHuwFYO1UWA8Z9hEgW.7KPXzWvbuU6K5qy")
            .build();
    private final User user2 = User.builder()
            .id(1L)
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("$2a$10$XHEl4ITYK7X72RnHRmxaHuwFYO1UWA8Z9hEgW.7KPXzWvbuU6K5qy")
            .build();
    private final AddUserDto addUserDto1 = AddUserDto.builder()
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();

    @Test
    public void addUserTest() {

    }

    @Test
    public void getUserTest() {

    }

    @Test
    public void getEntityTest() {

    }

    @Test
    public void getAllUsersTest() {

    }

    @Test
    public void deleteUserTest() {

    }
}
