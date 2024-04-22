package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.piwowarski.socialmediabackend.dto.user.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.User;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class UserMapper {

    public static User map(AddUserDto addUserDto, PasswordEncoder passwordEncoder) {
        return User.builder()
                .firstName(addUserDto.getFirstName())
                .lastName(addUserDto.getLastName())
                .email(addUserDto.getEmail())
                .password(passwordEncoder.encode(addUserDto.getPassword()))
                .build();
    }

    public static GetUserDto map(User user) {
		return GetUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
