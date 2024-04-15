package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;

@Repository
public interface FollowedUserRepository extends JpaRepository<FollowedUser, Long> {
}
