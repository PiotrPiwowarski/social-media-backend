package pl.piwowarski.socialmediabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.enums.ReactionType;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_reactions")
public class PostReaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;
}
