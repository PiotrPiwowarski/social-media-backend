package pl.piwowarski.socialmediabackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.AddUserDto;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.exception.UserAlreadyExistsException;
import pl.piwowarski.socialmediabackend.mapper.UserMapper;
import pl.piwowarski.socialmediabackend.repository.UserRepository;
import pl.piwowarski.socialmediabackend.service.UserService;

import java.util.Optional;

@RequiredArgsConstructor
public class UserServiceImplTest {

    private final AddUserDto addUserDto1 = AddUserDto.builder()
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();

    @Test
    public void addUserTest1() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);

        Mockito.when(userRepository.findUserByEmail("user1@gmail.com")).thenReturn(Optional.of(new User
                (1L, "user1", "user1", "user1@gmail.com", "user1")));

        Assertions.assertThrows(UserAlreadyExistsException.class, () -> userService.addUser(addUserDto1));
    }

    @Test
    public void addUserTest2() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);

        Mockito.when(userRepository.findUserByEmail("user1@gmail.com")).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(UserMapper.map(addUserDto1))).thenReturn(new User
                (1L, "user1", "user1", "user1@gmail.com", "user1"));

        Assertions.assertDoesNotThrow(() -> userService.addUser(addUserDto1));
    }

    @Test
    public void deleteUserTest() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);

        Assertions.assertDoesNotThrow(() -> userService.deleteUser(1L));
    }
}
