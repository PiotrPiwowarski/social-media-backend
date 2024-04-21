package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.service.commentReaction.CommentReactionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/commentReactions")
public class CommentReactionController {

    private final CommentReactionService commentReactionService;

    @PostMapping("/like")
    public ResponseEntity<Void> commentLike(@RequestBody AddReactionDto addReactionDto) {
        commentReactionService.addCommentLike(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dislike")
    public ResponseEntity<Void> commentDislike(@RequestBody AddReactionDto addReactionDto) {
        commentReactionService.addCommentDislike(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/likes")
    public ResponseEntity<GetReactionDto> getCommentLikes(@PathVariable long id) {
        GetReactionDto getReactionDto = commentReactionService.getCommentLikes(id);
        return ResponseEntity.ok(getReactionDto);
    }

    @GetMapping("/{id}/dislikes")
    public ResponseEntity<GetReactionDto> getCommentDislikes(@PathVariable long id) {
        GetReactionDto getReactionDto = commentReactionService.getCommentDislikes(id);
        return ResponseEntity.ok(getReactionDto);
    }
}
