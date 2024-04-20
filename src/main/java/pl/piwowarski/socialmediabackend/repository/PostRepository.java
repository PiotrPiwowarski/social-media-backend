package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("DELETE FROM Post p WHERE p.id = :id AND p.user.id = :userId")
    void delete(long id, long userId);
}
