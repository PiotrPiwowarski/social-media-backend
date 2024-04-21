package pl.piwowarski.socialmediabackend.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCommentDto {

    private Long id;
    private String content;
    private LocalDateTime dateTime;
    private int likes;
    private int dislikes;
    private long postId;
    private long userId;
    private String userFirstName;
    private String userLastName;
}
