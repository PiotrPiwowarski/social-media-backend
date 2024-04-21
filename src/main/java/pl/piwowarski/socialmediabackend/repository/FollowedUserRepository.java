package pl.piwowarski.socialmediabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piwowarski.socialmediabackend.entity.FollowedUser;

import java.util.List;

@Repository
public interface FollowedUserRepository extends JpaRepository<FollowedUser, Long> {

    List<FollowedUser> findByUserId(long userId);

    @Transactional
    @Modifying
    void deleteByUserIdAndFollowedUserId(long userId, long followedUserId);
}
