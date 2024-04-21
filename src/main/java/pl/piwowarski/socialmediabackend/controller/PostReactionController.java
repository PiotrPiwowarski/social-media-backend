package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.service.postReaction.PostReactionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/postReactions")
public class PostReactionController {

    private final PostReactionService postReactionService;

    @PostMapping("/like")
    public ResponseEntity<Void> postLike(@RequestBody AddReactionDto addReactionDto) {
        postReactionService.addPostLike(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dislike")
    public ResponseEntity<Void> postDislike(@RequestBody AddReactionDto addReactionDto) {
        postReactionService.addPostDislike(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/likes")
    public ResponseEntity<GetReactionDto> getPostLikes(@PathVariable long id) {
        GetReactionDto getReactionDto = postReactionService.getPostLikes(id);
        return ResponseEntity.ok(getReactionDto);
    }

    @GetMapping("/{id}/dislikes")
    public ResponseEntity<GetReactionDto> getPostDislikes(@PathVariable long id) {
        GetReactionDto getReactionDto= postReactionService.getPostDislikes(id);
        return ResponseEntity.ok(getReactionDto);
    }
}
