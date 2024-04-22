package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.post.AddPostDto;
import pl.piwowarski.socialmediabackend.dto.post.GetPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;

public class PostMapperTest {

    private final UserService userService = Mockito.mock(UserService.class);
    private final AddPostDto addPostDto = AddPostDto.builder()
            .userId(1L)
            .content("content")
            .build();
    private final User user = User.builder()
            .id(1L)
            .firstName("user")
            .lastName("user")
            .build();
    private final Post post = Post.builder()
            .user(user)
            .dateTime(LocalDateTime.of(2024, 4, 22, 22, 13, 21))
            .content("content")
            .build();
    private final Post post2 = Post.builder()
            .id(1L)
            .user(user)
            .dateTime(LocalDateTime.of(2024, 4, 22, 22, 13, 21))
            .content("content")
            .build();
    private final GetPostDto getPostDto = GetPostDto.builder()
            .id(1L)
            .content("content")
            .dateTime(LocalDateTime.of(2024, 4, 22, 22, 13, 21))
            .userFirstName("user")
            .userLastName("user")
            .userId(1L)
            .comments(null)
            .build();

    @Test
    public void postMapperAddPostDtoToPostTest() {
        Mockito.when(userService.getEntity(1L)).thenReturn(user);

        Post mappedPost = PostMapper.map(addPostDto, userService);
        mappedPost.setDateTime(LocalDateTime.of(2024, 4, 22, 22, 13, 21));

        Assertions.assertEquals(post, mappedPost);
    }

    @Test
    public void postMapperPostToGetPostDtoTest() {
        GetPostDto mappedGetPostDto = PostMapper.map(post2, null);

        Assertions.assertEquals(getPostDto, mappedGetPostDto);
    }
}
