package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.comment.GetCommentDto;
import pl.piwowarski.socialmediabackend.dto.post.AddPostDto;
import pl.piwowarski.socialmediabackend.dto.post.GetPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;
import java.util.List;

public class CommentMapperTest {

    private final UserService userService = Mockito.mock(UserService.class);
    private final GetCommentDto getCommentDto = GetCommentDto.builder()
            .id(1L)
            .userId(1L)
            .postId(1L)
            .userFirstName("user")
            .userLastName("user")
            .dateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0))
            .content("content")
            .build();
    private final List<GetCommentDto> comments = List.of(getCommentDto);
    private final AddPostDto addPostDto = AddPostDto.builder()
            .content("content")
            .userId(1L)
            .build();
    private final GetPostDto getPostDto = GetPostDto.builder()
            .userId(1L)
            .id(1L)
            .comments(comments)
            .content("content")
            .dateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0))
            .userFirstName("user")
            .userLastName("user")
            .build();
    private final Post post1 = Post.builder()
            .id(1L)
            .content("content")
            .user(User.builder().id(1L).firstName("user").lastName("user").build())
            .dateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0))
            .build();
    private final Post post2 = Post.builder()
            .content("content")
            .dateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0))
            .build();

    @Test
    public void postMapperAddPostDtoToPostMapper() {
        Mockito.when(userService.getEntity(1L)).thenReturn(null);
        Post mappedPost = PostMapper.map(addPostDto, userService);
        mappedPost.setDateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0));

        Assertions.assertEquals(post2, mappedPost);
    }

    @Test
    public void postMapperPostToGetPostDtoMapper() {
        GetPostDto mappedGetPostDto = PostMapper.map(post1, comments);

        Assertions.assertEquals(getPostDto, mappedGetPostDto);
    }
}
