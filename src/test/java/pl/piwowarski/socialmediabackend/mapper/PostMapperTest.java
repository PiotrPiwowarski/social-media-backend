package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.post.AddPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;

public class PostMapperTest {

    private final LocalDateTime dateTime = LocalDateTime.of(2024, 7, 1, 12, 21, 33);

    private final User user = User.builder()
            .id(1L)
            .firstName("user")
            .lastName("user")
            .email("user@gmail.com")
            .password("user")
            .build();

    private final AddPostDto addPostDto = AddPostDto.builder()
            .userId(1L)
            .content("content")
            .build();

    private final Post post = Post.builder()
            .content("content")
            .user(user)
            .dateTime(dateTime)
            .build();

    private final UserService userService = Mockito.mock(UserService.class);

    @Test
    public void mapDtoToEntity() {
        Mockito.when(userService.getEntity(1L)).thenReturn(user);

        try(var mock = Mockito.mockStatic(LocalDateTime.class)) {
            Mockito.when(LocalDateTime.now()).thenReturn(dateTime);

            Post result = PostMapper.map(addPostDto, userService);

            Assertions.assertEquals(post, result);
        }
    }
}
