package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.User;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper {

    public static User map(AddUserDto addUserDto) {
        return User.builder()
                .firstName(addUserDto.getFirstName())
                .lastName(addUserDto.getLastName())
                .email(addUserDto.getEmail())
                .password(addUserDto.getPassword())
                .build();
    }

    public static GetUserDto map(User user) {
		return GetUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}