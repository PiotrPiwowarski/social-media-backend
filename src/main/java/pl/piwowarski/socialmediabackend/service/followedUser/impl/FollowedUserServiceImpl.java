package pl.piwowarski.socialmediabackend.service.followedUser.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;
import pl.piwowarski.socialmediabackend.mapper.FollowedUserMapper;
import pl.piwowarski.socialmediabackend.repository.FollowedUserRepository;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;

@Service
@RequiredArgsConstructor
public class FollowedUserServiceImpl implements FollowedUserService {

    private final FollowedUserRepository followedUserRepository;

    @Override
    public long addUserToFollowers(FollowedUserDto followedUserDto) {
        FollowedUser followedUser = followedUserRepository.save(FollowedUserMapper.map(followedUserDto));
        return followedUser.getId();
    }
}
