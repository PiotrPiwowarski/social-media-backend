package pl.piwowarski.socialmediabackend.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import pl.piwowarski.socialmediabackend.entity.AuthenticationToken;

import java.util.Optional;

@Repository
public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken, Long> {

    Optional<AuthenticationToken> findByToken(String token);
    @Transactional
    @Modifying
    void deleteByUserId(long id);
    @Transactional
    @Modifying
    void deleteByToken(String token);
}
