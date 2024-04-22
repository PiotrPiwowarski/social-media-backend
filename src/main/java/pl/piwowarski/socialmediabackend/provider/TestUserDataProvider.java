package pl.piwowarski.socialmediabackend.provider;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.user.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestUserDataProvider {

    public static GetUserDto getUserDto1 = GetUserDto.builder()
            .id(1L)
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .build();

    public static User user1 = User.builder()
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("$2a$10$XHEl4ITYK7X72RnHRmxaHuwFYO1UWA8Z9hEgW.7KPXzWvbuU6K5qy")
            .build();

    public static User user2 = User.builder()
            .id(1L)
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("$2a$10$XHEl4ITYK7X72RnHRmxaHuwFYO1UWA8Z9hEgW.7KPXzWvbuU6K5qy")
            .build();

    public static AddUserDto addUserDto1 = AddUserDto.builder()
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();
}
