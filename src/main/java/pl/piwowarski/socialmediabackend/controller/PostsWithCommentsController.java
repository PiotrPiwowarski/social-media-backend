package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.post.GetPostDto;
import pl.piwowarski.socialmediabackend.service.postsWithComments.PostsWithCommentsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/postsWithComments")
public class PostsWithCommentsController {

    private final PostsWithCommentsService postsWithCommentsService;

    @GetMapping
    public ResponseEntity<List<GetPostDto>> getAllPostsWithComments() {
        List<GetPostDto> allPostsWithComments = postsWithCommentsService.getAllPostsWithComments();
        return ResponseEntity.ok(allPostsWithComments);
    }

    @GetMapping("/followedUser/{userId}")
    public ResponseEntity<List<GetPostDto>> getFollowedUsersPostsWithComments(@PathVariable long userId) {
        List<GetPostDto> allPostsWithComments = postsWithCommentsService.getFollowedUsersPostsWithComments(userId);
        return ResponseEntity.ok(allPostsWithComments);
    }
}
