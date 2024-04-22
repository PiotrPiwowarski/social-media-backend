package pl.piwowarski.socialmediabackend.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.comment.GetCommentDto;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPostDto {

    private Long id;
    private String content;
    private LocalDateTime dateTime;
    private long userId;
    private String userFirstName;
    private String userLastName;
    private List<GetCommentDto> comments;
}
