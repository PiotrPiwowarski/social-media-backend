package pl.piwowarski.socialmediabackend.service.postsWithComments.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.post.GetPostDto;
import pl.piwowarski.socialmediabackend.entity.Comment;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.postsWithComments.PostsWithCommentsService;

import java.time.LocalDateTime;
import java.util.List;

public class PostsWithCommentsServiceImplTest {

    private final PostService postService = Mockito.mock(PostService.class);
    private final CommentService commentService = Mockito.mock(CommentService.class);
    private final FollowedUserService followedUserService = Mockito.mock(FollowedUserService.class);
    private  final PostsWithCommentsService postsWithCommentsService = new PostsWithCommentsServiceImpl(
            followedUserService,
            postService,
            commentService
    );
    private final User user1 = User.builder()
            .id(1L)
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("$2a$10$XHEl4ITYK7X72RnHRmxaHuwFYO1UWA8Z9hEgW.7KPXzWvbuU6K5qy")
            .build();
    private final Post post1 = Post.builder()
            .id(1L)
            .content("content")
            .user(user1)
            .build();
    private final List<GetPostDto> data = List.of(GetPostDto.builder()
                    .id(1L)
                    .content("content")
                    .dateTime(null)
                    .comments(List.of())
                    .userId(1L)
                    .userFirstName("user1")
                    .userLastName("user1")
                    .build());

    @Test
    public void getAllPostsWithCommentsTest() {
        Mockito.when(postService.getAllPosts()).thenReturn(List.of(post1));
        Mockito.when(postService.getEntity(1L)).thenReturn(post1);

        List<GetPostDto> getPostDtoList = postsWithCommentsService.getAllPostsWithComments();

        Assertions.assertEquals(data, getPostDtoList);
    }


}
