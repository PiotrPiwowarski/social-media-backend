package pl.piwowarski.socialmediabackend.service.followedUser;

import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;

public interface FollowedUserService {

    long addUserToFollowers(FollowedUserDto followedUserDto);
}
