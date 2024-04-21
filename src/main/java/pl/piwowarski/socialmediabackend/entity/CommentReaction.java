package pl.piwowarski.socialmediabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.enums.ReactionType;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment_reactions")
public class CommentReaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private ReactionType reactionType;
    @ManyToOne
    private Comment comment;
    @ManyToOne
    private User user;
}
