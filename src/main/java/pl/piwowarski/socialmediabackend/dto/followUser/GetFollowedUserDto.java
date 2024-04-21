package pl.piwowarski.socialmediabackend.dto.followUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFollowedUserDto {

    private long id;
    private long followedUserId;
    private String firstName;
    private String lastName;
}
