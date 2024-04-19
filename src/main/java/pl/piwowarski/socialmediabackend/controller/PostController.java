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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}
