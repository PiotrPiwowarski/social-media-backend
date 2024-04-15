package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Test;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
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

    @Test
    public void mapDtoToEntityTest() {
        followedUser1.setId(null);
        assertEquals(FollowedUserMapper.map(followedUserDto1), followedUser1);
    }
}
