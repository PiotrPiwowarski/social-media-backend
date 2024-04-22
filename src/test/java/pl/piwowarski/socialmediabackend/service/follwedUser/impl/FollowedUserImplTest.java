package pl.piwowarski.socialmediabackend.service.follwedUser.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.followUser.AddFollowedUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;
import pl.piwowarski.socialmediabackend.mapper.FollowedUserMapper;
import pl.piwowarski.socialmediabackend.repository.FollowedUserRepository;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;
import pl.piwowarski.socialmediabackend.service.followedUser.impl.FollowedUserServiceImpl;
import pl.piwowarski.socialmediabackend.service.user.UserService;

public class FollowedUserImplTest {

    private final FollowedUserRepository followedUserRepository = Mockito.mock(FollowedUserRepository.class);
    private final UserService userService = Mockito.mock(UserService.class);
    private final FollowedUserService followedUserService =
            new FollowedUserServiceImpl(followedUserRepository, userService);
    private final AddFollowedUserDto addFollowedUserDto1 = AddFollowedUserDto.builder()
            .userId(1L)
            .followedUserId(2L)
            .build();
    private final FollowedUser followedUser1 = FollowedUser.builder()
            .build();
    private final FollowedUser followedUser2 = FollowedUser.builder()
            .id(1L)
            .build();


    @Test
    public void addUserToFollowersTest() {
        Mockito.when(followedUserRepository.save(followedUser1)).thenReturn(followedUser2);
         try(var mock = Mockito.mockStatic(FollowedUserMapper.class)) {
             Mockito.when(FollowedUserMapper.map(addFollowedUserDto1, userService)).thenReturn(followedUser1);

             Assertions.assertEquals(1L, followedUserService.addUserToFollowers(addFollowedUserDto1));
         }
    }
}
