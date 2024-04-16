package pl.piwowarski.socialmediabackend.service.followedUser;

import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetFollowedUserDto;

import java.util.List;

public interface FollowedUserService {

    long addUserToFollowers(FollowedUserDto followedUserDto);
    List<GetFollowedUserDto> getFollowedUsers(long userId);
    void deleteUserFromFollowers(long id);
}
