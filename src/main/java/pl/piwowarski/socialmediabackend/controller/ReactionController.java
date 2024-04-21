package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.service.reaction.ReactionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    @PostMapping("/like")
    public ResponseEntity<Void> commentLike(@RequestBody AddReactionDto addReactionDto) {
        reactionService.addCommentLike(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dislike")
    public ResponseEntity<Void> commentDislike(@RequestBody AddReactionDto addReactionDto) {
        reactionService.addCommentDislike(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/likes")
    public ResponseEntity<GetReactionDto> getCommentLikes(@PathVariable long id) {
        GetReactionDto getReactionDto = reactionService.getCommentLikes(id);
        return ResponseEntity.ok(getReactionDto);
    }

    @GetMapping("/{id}/dislikes")
    public ResponseEntity<GetReactionDto> getCommentDislikes(@PathVariable long id) {
        GetReactionDto getReactionDto = reactionService.getCommentDislikes(id);
        return ResponseEntity.ok(getReactionDto);
    }

    @PostMapping("/like")
    public ResponseEntity<Void> postLike(@RequestBody AddReactionDto addReactionDto) {
        reactionService.addPostLike(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dislike")
    public ResponseEntity<Void> postDislike(@RequestBody AddReactionDto addReactionDto) {
        reactionService.addPostDislike(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/likes")
    public ResponseEntity<GetReactionDto> getPostLikes(@PathVariable long id) {
        GetReactionDto getReactionDto = reactionService.getPostLikes(id);
        return ResponseEntity.ok(getReactionDto);
    }

    @GetMapping("/{id}/dislikes")
    public ResponseEntity<GetReactionDto> getPostDislikes(@PathVariable long id) {
        GetReactionDto getReactionDto= reactionService.getPostDislikes(id);
        return ResponseEntity.ok(getReactionDto);
    }
}
