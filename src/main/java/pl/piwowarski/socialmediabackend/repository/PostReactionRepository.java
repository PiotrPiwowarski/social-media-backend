package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.PostReaction;
import pl.piwowarski.socialmediabackend.enums.ReactionType;

import java.util.Optional;

@Repository
public interface PostReactionRepository extends JpaRepository<PostReaction, Long> {

    Optional<PostReaction> findByUserIdAndPostId(long userId, long postId);
    int countAllByPostIdAndReactionType(long postId, ReactionType reactionType);
}
