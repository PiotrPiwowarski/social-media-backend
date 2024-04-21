package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.comment.AddCommentDto;
import pl.piwowarski.socialmediabackend.entity.Comment;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;

public class CommentMapperTest {

    private final UserService userService = Mockito.mock(UserService.class);
    private final PostService postService = Mockito.mock(PostService.class);

    private final AddCommentDto addCommentDto = AddCommentDto.builder()
            .content("content")
            .userId(1L)
            .postId(1L)
            .build();

    private final User user = User.builder()
            .id(1L)
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .password("user")
            .build();

    private final LocalDateTime dateTime = LocalDateTime.of(2024, 7, 1, 12, 21, 33);

    private final Post post = Post.builder()
            .id(1L)
            .user(user)
            .content("content")
            .dateTime(dateTime)
            .likes(10)
            .dislikes(10)
            .build();

    private final Comment comment = Comment.builder()
            .user(user)
            .post(post)
            .dateTime(dateTime)
            .content("content")
            .build();

    @Test
    public void mapDtoToEntity() {
        Mockito.when(userService.getEntity(1L)).thenReturn(user);
        Mockito.when(postService.getEntity(1L)).thenReturn(post);

        try(MockedStatic<LocalDateTime> staticMock = Mockito.mockStatic(LocalDateTime.class)) {
            Mockito.when(LocalDateTime.now()).thenReturn(dateTime);

            Comment result = CommentMapper.map(addCommentDto, userService, postService);

            Assertions.assertEquals(comment, result);
        }
    }
}
