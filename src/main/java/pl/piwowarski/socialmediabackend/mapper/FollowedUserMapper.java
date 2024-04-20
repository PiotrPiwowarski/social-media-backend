package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FollowedUserMapper {

    public static FollowedUser map(FollowedUserDto followedUserDto, UserService userService) {
        return FollowedUser.builder()
                .user(userService.getEntity(followedUserDto.getUserId()))
                .followedUser(userService.getEntity(followedUserDto.getUserId()))
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
