package pl.piwowarski.socialmediabackend.dto.reaction;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;
}
