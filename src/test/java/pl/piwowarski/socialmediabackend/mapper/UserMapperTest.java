package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.piwowarski.socialmediabackend.dto.user.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.User;

public class UserMapperTest {

    private final PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
    private final AddUserDto addUserDto = AddUserDto.builder()
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .password("user")
            .build();
    private final User user1 = User.builder()
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .password("****")
            .build();
    private final User user2 = User.builder()
            .id(1L)
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .password("****")
            .build();
    private final GetUserDto getUserDto = GetUserDto.builder()
            .id(1L)
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .build();

    @Test
    public void userMapperAddUserDtoToUserMapperTest() {
        Mockito.when(passwordEncoder.encode("user")).thenReturn("****");
        User mapppeUser = UserMapper.map(addUserDto, passwordEncoder);
        Assertions.assertEquals(user1, mapppeUser);
    }

    @Test
    public void userMapperUserToGetUserDtoMapperTest() {
        GetUserDto mappedGetUserDto = UserMapper.map(user2);
        Assertions.assertEquals(getUserDto, mappedGetUserDto);
    }
}
