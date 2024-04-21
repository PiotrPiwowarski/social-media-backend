package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.CommentReaction;
import pl.piwowarski.socialmediabackend.enums.ReactionType;

import java.util.Optional;

@Repository
public interface CommentReactionRepository extends JpaRepository<CommentReaction, Long> {

    Optional<CommentReaction> findByUserIdAndCommentId(long userId, long commentId);
    int countAllByCommentIdAndReactionType(long commentId, ReactionType reactionType);
}
