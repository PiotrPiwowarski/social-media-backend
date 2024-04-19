package pl.piwowarski.socialmediabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCommentDto {

    private String content;
    private long userId;
    private long postId;
}
