package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
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
}
