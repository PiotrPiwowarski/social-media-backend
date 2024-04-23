package pl.piwowarski.socialmediabackend.service.postsWithComments.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.post.GetPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;
import pl.piwowarski.socialmediabackend.service.post.PostService;

import java.util.List;

public class PostsWithCommentsServiceImplTest {

    private final PostService postService = Mockito.mock(PostService.class);
    private final CommentService commentService = Mockito.mock(CommentService.class);
    private final FollowedUserService followedUserService = Mockito.mock(FollowedUserService.class);

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

    }


}
