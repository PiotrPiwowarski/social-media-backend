package pl.piwowarski.socialmediabackend.dto.reaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.enums.ReactionType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddReactionDto {

    private long structureId;
    private long userId;
    private ReactionType reactionType;
}
