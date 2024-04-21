package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.followUser.AddFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.followUser.GetFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FollowedUserMapper {

    public static FollowedUser map(AddFollowedUserDto addFollowedUserDto, UserService userService) {
        return FollowedUser.builder()
                .user(userService.getEntity(addFollowedUserDto.getUserId()))
                .followedUser(userService.getEntity(addFollowedUserDto.getFollowedUserId()))
                .build();
    }

    public static GetFollowedUserDto map(Long id, GetUserDto user) {
        return GetFollowedUserDto.builder()
                .id(id)
                .followedUserId(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
