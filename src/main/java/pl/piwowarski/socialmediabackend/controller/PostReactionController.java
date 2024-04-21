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

    @PostMapping
    public ResponseEntity<Void> addPostReaction(@RequestBody AddReactionDto addReactionDto) {
        postReactionService.addPostReaction(addReactionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}/likes")
    public ResponseEntity<GetReactionDto> getPostLikes(@PathVariable long postId) {
        GetReactionDto getReactionDto = postReactionService.getPostLikes(postId);
        return ResponseEntity.ok(getReactionDto);
    }

    @GetMapping("/{postId}/dislikes")
    public ResponseEntity<GetReactionDto> getPostDislikes(@PathVariable long postId) {
        GetReactionDto getReactionDto= postReactionService.getPostDislikes(postId);
        return ResponseEntity.ok(getReactionDto);
    }
}
