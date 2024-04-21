package pl.piwowarski.socialmediabackend.dto.followUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddFollowedUserDto {

    private long userId;
    private long followedUserId;
}
