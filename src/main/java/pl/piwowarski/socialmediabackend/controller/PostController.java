package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.AddPostDto;
import pl.piwowarski.socialmediabackend.service.post.PostService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> addPost(@RequestBody AddPostDto addPostDto) {
        long id = postService.addPost(addPostDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}/user/{userId}")
    public ResponseEntity<Void> deletePost(@PathVariable long id, @PathVariable long userId) {
        postService.deletePost(id, userId);
        return ResponseEntity.ok().build();
    }
}
