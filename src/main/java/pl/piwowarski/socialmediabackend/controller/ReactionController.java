package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentDislikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentLikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.PostDislikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.PostLikeDto;
import pl.piwowarski.socialmediabackend.service.reaction.ReactionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    @PostMapping("/like")
    public ResponseEntity<Void> commentLike(@RequestBody CommentLikeDto commentLikeDto) {
        reactionService.addCommentLike(commentLikeDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dislike")
    public ResponseEntity<Void> commentDislike(@RequestBody CommentDislikeDto commentDislikeDto) {
        reactionService.addCommentDislike(commentDislikeDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/like")
    public ResponseEntity<Void> postLike(@RequestBody PostLikeDto postLikeDto) {
        reactionService.addPostLike(postLikeDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dislike")
    public ResponseEntity<Void> postDislike(@RequestBody PostDislikeDto postDislikeDto) {
        reactionService.addPostDislike(postDislikeDto);
        return ResponseEntity.ok().build();
    }
}
