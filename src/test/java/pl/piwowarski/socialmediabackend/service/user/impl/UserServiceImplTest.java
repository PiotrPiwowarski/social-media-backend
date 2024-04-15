package pl.piwowarski.socialmediabackend.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.exception.UserAlreadyExistsException;
import pl.piwowarski.socialmediabackend.repository.UserRepository;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
public class UserServiceImplTest {

    UserRepository userRepository = Mockito.mock(UserRepository.class);
    UserService userService = new UserServiceImpl(userRepository);

    private final AddUserDto addUserDto1 = AddUserDto.builder()
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();

    private final User user1 = User.builder()
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();

    private final User user2 = User.builder()
            .id(1L)
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();

    private final GetUserDto getUserDto1 = GetUserDto.builder()
            .id(1L)
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();

    @Test
    public void addUserTest1() {
        when(userRepository.findUserByEmail("user1@gmail.com")).thenReturn(Optional.of(user1));

        assertThrows(UserAlreadyExistsException.class, () -> userService.addUser(addUserDto1));
    }

    @Test
    public void addUserTest2() {
        when(userRepository.findUserByEmail("user1@gmail.com")).thenReturn(Optional.empty());
        when(userRepository.save(user1)).thenReturn(user2);

        assertDoesNotThrow(() -> userService.addUser(addUserDto1));
    }

    @Test
    public void getUserTest() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user2));

        assertEquals(userService.getUser(1L), getUserDto1);
    }

    @Test
    public void getAllUsersTest() {
        when(userRepository.findAll()).thenReturn(List.of(user2));

        assertEquals(userService.getAllUsers(), List.of(getUserDto1));
    }

    @Test
    public void deleteUserTest() {
        assertDoesNotThrow(() -> userService.deleteUser(1L));
    }
}
