package pl.piwowarski.socialmediabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "followed_users")
public class FollowedUser {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
    private User user;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
    private User followedUser;
}
