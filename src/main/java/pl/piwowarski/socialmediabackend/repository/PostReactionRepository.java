package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.PostReaction;

@Repository
public interface PostReactionRepository extends JpaRepository<PostReaction, Long> {
}
