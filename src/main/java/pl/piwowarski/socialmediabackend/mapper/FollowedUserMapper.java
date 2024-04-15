package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FollowedUserMapper {

    public static FollowedUser map(FollowedUserDto followedUserDto) {
        return FollowedUser.builder()
                .userId(followedUserDto.getUserId())
                .followedUserId(followedUserDto.getFollowedUserId())
                .build();
    }
}
