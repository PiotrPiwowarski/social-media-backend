package pl.piwowarski.socialmediabackend.service.follwedUser.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;
import pl.piwowarski.socialmediabackend.repository.FollowedUserRepository;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;
import pl.piwowarski.socialmediabackend.service.followedUser.impl.FollowedUserServiceImpl;

import static org.mockito.Mockito.when;

public class FollowedUserImplTest {

    private final FollowedUserRepository followedUserRepository = Mockito.mock(FollowedUserRepository.class);
    private final FollowedUserService followedUserService = new FollowedUserServiceImpl(followedUserRepository);

    private final FollowedUserDto followedUserDto1 = FollowedUserDto.builder()
            .userId(1L)
            .followedUserId(2L)
            .build();

    private final FollowedUser followedUser1 = FollowedUser.builder()
            .userId(1L)
            .followedUserId(2L)
            .build();

    private final FollowedUser followedUser2 = FollowedUser.builder()
            .id(1L)
            .userId(1L)
            .followedUserId(2L)
            .build();

    @Test
    public void addUserToFollowersTest() {
		when(followedUserRepository.save(followedUser1)).thenReturn(followedUser2);

        Assertions.assertEquals(followedUserService.addUserToFollowers(followedUserDto1),followedUser2.getId());
    }
}
