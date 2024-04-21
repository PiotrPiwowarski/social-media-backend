package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.comment.AddCommentDto;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> addComment(@RequestBody AddCommentDto addCommentDto) {
        long id = commentService.addComment(addCommentDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}/user/{userId}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id, @PathVariable long userId) {
        commentService.deleteComment(id, userId);
        return ResponseEntity.ok().build();
    }
}
