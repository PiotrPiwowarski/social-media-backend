package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.AddCommentDto;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> addPost(@RequestBody AddCommentDto addCommentDto) {
        long id = commentService.addComment(addCommentDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }
}
