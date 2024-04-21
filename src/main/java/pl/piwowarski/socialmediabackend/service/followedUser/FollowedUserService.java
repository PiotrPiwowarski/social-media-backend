package pl.piwowarski.socialmediabackend.service.followedUser;

import pl.piwowarski.socialmediabackend.dto.followUser.AddFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.followUser.GetFollowedUserDto;

import java.util.List;

public interface FollowedUserService {

    long addUserToFollowers(AddFollowedUserDto addFollowedUserDto);
    List<GetFollowedUserDto> getFollowedUsers(long userId);
    void deleteUserFromFollowers(long userId, long followedUserId);
}
