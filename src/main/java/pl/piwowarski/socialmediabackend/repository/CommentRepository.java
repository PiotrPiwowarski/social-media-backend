package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(long postId);
    @Query("DELETE FROM Comment c WHERE c.id = :id AND c.user.id = :userId")
    void delete(long id, long userId);
}
