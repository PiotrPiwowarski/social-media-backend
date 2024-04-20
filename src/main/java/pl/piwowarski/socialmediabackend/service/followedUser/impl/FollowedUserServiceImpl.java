package pl.piwowarski.socialmediabackend.service.followedUser.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.mapper.FollowedUserMapper;
import pl.piwowarski.socialmediabackend.repository.FollowedUserRepository;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowedUserServiceImpl implements FollowedUserService {

    private final FollowedUserRepository followedUserRepository;
    private final UserService userService;

    @Override
    public long addUserToFollowers(FollowedUserDto followedUserDto) {
        FollowedUser followedUser = followedUserRepository.save(FollowedUserMapper.map(followedUserDto));
        return followedUser.getId();
    }

    @Override
    public List<GetFollowedUserDto> getFollowedUsers(long userId) {
        List<FollowedUser> followedUsers = followedUserRepository.findByUserId(userId);
        return followedUsers.stream()
                .map(this::getFollowedUserDto)
                .toList();
    }

    @Override
    public List<User> getFollowedUsersEntities(long userId) {
        return followedUserRepository.findByUserId(userId)
                .stream()
                .map(followedUser -> userService.getEntity(followedUser.getFollowedUserId())).toList();
    }

    private GetFollowedUserDto getFollowedUserDto(FollowedUser followedUser) {
        GetUserDto user = userService.getUser(followedUser.getFollowedUserId());
        return FollowedUserMapper.map(followedUser.getId(), user);
    }

    @Override
    public void deleteUserFromFollowers(long id) {
        followedUserRepository.deleteById(id);
    }
}
