package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;

import java.util.List;

@Repository
public interface FollowedUserRepository extends JpaRepository<FollowedUser, Long> {

    List<FollowedUser> findByUserId(long userId);
    void deleteByUserIdAndFollowedUserId(long userId, long followedUserId);
}
