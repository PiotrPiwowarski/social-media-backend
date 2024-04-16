package pl.piwowarski.socialmediabackend.service.follwedUser.impl;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;
import pl.piwowarski.socialmediabackend.mapper.FollowedUserMapper;
import pl.piwowarski.socialmediabackend.repository.FollowedUserRepository;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;
import pl.piwowarski.socialmediabackend.service.followedUser.impl.FollowedUserServiceImpl;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FollowedUserImplTest {

    private final FollowedUserRepository followedUserRepository = mock(FollowedUserRepository.class);
    private final UserService userService = mock(UserService.class);
    private final FollowedUserService followedUserService = new FollowedUserServiceImpl(followedUserRepository, userService);

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

    private final GetUserDto getUserDto = GetUserDto.builder()
            .id(2L)
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .password("user")
            .build();

    private final GetFollowedUserDto getFollowedUserDto = GetFollowedUserDto.builder()
            .id(1L)
            .followedUserId(2L)
            .firstName("user")
            .lastName("user")
            .build();

    @Test
    public void addUserToFollowersTest() {
        try(MockedStatic<FollowedUserMapper> staticMock = Mockito.mockStatic(FollowedUserMapper.class)) {
            when(followedUserRepository.save(followedUser1)).thenReturn(followedUser2);
            when(FollowedUserMapper.map(followedUserDto1)).thenReturn(followedUser1);

            assertEquals(followedUser2.getId(), followedUserService.addUserToFollowers(followedUserDto1));
        }
    }

    @Test
    public void getFollowedUsersTest() {
        try(MockedStatic<FollowedUserMapper> staticMock = Mockito.mockStatic(FollowedUserMapper.class)) {
            when(followedUserRepository.findByUserId(1L)).thenReturn(List.of(followedUser2));
            when(userService.getUser(2L)).thenReturn(getUserDto);
            when(FollowedUserMapper.map(1L, getUserDto)).thenReturn(getFollowedUserDto);

            assertEquals(List.of(getFollowedUserDto), followedUserService.getFollowedUsers(1L));
        }
    }

    @Test
    public void deleteUserFromFollowedUsers() {
		assertDoesNotThrow(() -> followedUserService.deleteUserFromFollowers(1L));
    }
}
