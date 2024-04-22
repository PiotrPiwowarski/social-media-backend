package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.followUser.AddFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.followUser.GetFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.service.user.UserService;

public class FollowedUserMapperTest {

    private final UserService userService = Mockito.mock(UserService.class);
    private final User user1 = User.builder()
            .id(1L)
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password(null)
            .build();
    private final User user2 = User.builder()
            .id(2L)
            .firstName("user2")
            .lastName("user2")
            .email("user2@gmail.com")
            .password(null)
            .build();
    private final AddFollowedUserDto addFollowedUserDto = AddFollowedUserDto.builder()
            .userId(1L)
            .followedUserId(2L)
            .build();
    private final FollowedUser followedUser = FollowedUser.builder()
            .user(user1)
            .followedUser(user2)
            .build();
    private final GetFollowedUserDto getFollowedUserDto = GetFollowedUserDto.builder()
            .id(1L)
            .followedUserId(1L)
            .firstName("user")
            .lastName("user")
            .build();
    private final GetUserDto getUserDto = GetUserDto.builder()
            .id(1L)
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .build();

    @Test
    public void FollowedUserMapperAddFollowedUserDtoToFollowedUserTest() {
        Mockito.when(userService.getEntity(1L)).thenReturn(user1);
        Mockito.when(userService.getEntity(2L)).thenReturn(user2);

        FollowedUser mappedFollowedUser = FollowedUserMapper.map(addFollowedUserDto, userService);

        Assertions.assertEquals(followedUser, mappedFollowedUser);
    }

    @Test
    public void FollowedUserMapperGetUserDtoToGetFollowedUserDto() {
        GetFollowedUserDto mappedGetFollowedUserDto = FollowedUserMapper.map(1L, getUserDto);

        Assertions.assertEquals(getFollowedUserDto, mappedGetFollowedUserDto);
    }
}
