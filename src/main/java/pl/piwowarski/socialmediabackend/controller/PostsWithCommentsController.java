package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piwowarski.socialmediabackend.dto.GetPostDto;
import pl.piwowarski.socialmediabackend.service.postsWithComments.PostsWithCommentsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/postsWithComments")
public class PostsWithCommentsController {

    private final PostsWithCommentsService postsWithCommentsService;

    @GetMapping
    public ResponseEntity<List<GetPostDto>> getAllPosts() {
        List<GetPostDto> allPostsWithComments = postsWithCommentsService.getAllPostsWithComments();
        return ResponseEntity.ok(allPostsWithComments);
    }
}
