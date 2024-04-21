package pl.piwowarski.socialmediabackend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
