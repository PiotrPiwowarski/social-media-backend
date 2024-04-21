package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.CommentReaction;

@Repository
public interface CommentReactionRepository extends JpaRepository<CommentReaction, Long> {
}
