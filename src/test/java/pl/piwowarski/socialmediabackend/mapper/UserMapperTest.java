package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piwowarski.socialmediabackend.dto.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.User;

public class UserMapperTest {

    private final AddUserDto addUserDto1 = AddUserDto.builder()
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();

    private final User user1 = User.builder()
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
    public void mapDtoToEntityTest() {
        user1.setId(null);
        Assertions.assertEquals(UserMapper.map(addUserDto1), user1);
    }

    @Test
    public void mapEntityToDtoTest() {
        Assertions.assertEquals(UserMapper.map(user1), getUserDto1);
    }
}
