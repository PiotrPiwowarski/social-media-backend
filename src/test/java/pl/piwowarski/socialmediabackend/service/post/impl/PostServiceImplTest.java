package pl.piwowarski.socialmediabackend.service.post.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.AddPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.mapper.PostMapper;
import pl.piwowarski.socialmediabackend.repository.PostRepository;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;
import java.util.Optional;

public class PostServiceImplTest {

    private final AddPostDto addPostDto  = AddPostDto.builder()
            .content("content")
            .userId(1L)
            .build();

    private final User user1 = User.builder()
            .id(1L)
            .firstName("user1")
            .lastName("user1")
            .email("user1@gmail.com")
            .password("user1")
            .build();

    private final Post post = Post.builder()
            .user(user1)
            .content("content")
            .build();

    private final Post post2 = Post.builder()
            .id(1L)
            .dateTime(LocalDateTime.of(2024, 4, 3, 12, 7, 12))
            .user(user1)
            .content("content")
            .build();

    private final PostRepository postRepository = Mockito.mock(PostRepository.class);
    private final UserService userService = Mockito.mock(UserService.class);
    private final PostService postService = new PostServiceImpl(postRepository, userService);

    @Test
    public void addPostTest() {
        Mockito.when(postRepository.save(post)).thenReturn(post2);

        try(var mock = Mockito.mockStatic(PostMapper.class)) {
            Mockito.when(PostMapper.map(addPostDto, userService)).thenReturn(post);

            Assertions.assertEquals(1L, postService.addPost(addPostDto));
        }
    }

    @Test
    public void getEntityTest() {
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.of(post2));

        Assertions.assertEquals(post2, postService.getEntity(1L));
    }
}
