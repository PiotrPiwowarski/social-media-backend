package pl.piwowarski.socialmediabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime dateTime;
    private int likes = 0;
    private int dislikes = 0;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;
}
