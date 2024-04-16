package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Test;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FollowedUserMapperTest {

    private final FollowedUserDto followedUserDto1 = FollowedUserDto.builder()
            .userId(1L)
            .followedUserId(2L)
            .build();

    private final FollowedUser followedUser1 = FollowedUser.builder()
            .id(1L)
            .userId(1L)
            .followedUserId(2L)
            .build();

    private final GetFollowedUserDto getFollowedUserDto1 = GetFollowedUserDto.builder()
            .id(1L)
            .followedUserId(2L)
            .firstName("user")
            .lastName("user")
            .build();

    private final GetUserDto getUserDto1 = GetUserDto.builder()
            .id(2L)
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .password("user")
            .build();

    @Test
    public void mapDtoToEntityTest() {
        followedUser1.setId(null);
        assertEquals(followedUser1, FollowedUserMapper.map(followedUserDto1));
    }

    @Test
    public void mapDtoToDto() {
        assertEquals(getFollowedUserDto1, FollowedUserMapper.map(1L, getUserDto1));
    }
}
