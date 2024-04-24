package pl.piwowarski.socialmediabackend.service.post.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.post.AddPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.mapper.PostMapper;
import pl.piwowarski.socialmediabackend.repository.PostRepository;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

public class PostServiceImplTest {

    private final PostRepository postRepository = Mockito.mock(PostRepository.class);
    private final UserService userService = Mockito.mock(UserService.class);
    private final PostService postService = new PostServiceImpl(postRepository, userService);
    private final AddPostDto addPostDto1 = AddPostDto.builder()
            .userId(1L)
            .content("content")
            .build();
    private final Post post1 = Post.builder()
            .content("content")
            .build();
    private final Post post2 = Post.builder()
            .id(1L)
            .content("content")
            .build();

    @Test
    public void addPostTest() {
        Mockito.when(postRepository.save(post1)).thenReturn(post2);

        try(var mock = Mockito.mockStatic(PostMapper.class)) {
            Mockito.when(PostMapper.map(addPostDto1, userService)).thenReturn(post1);

            Assertions.assertEquals(post2.getId(), postService.addPost(addPostDto1));
        }
    }

    @Test
    public void getEntityTest() {

    }

    @Test
    public void getAllPostsTest() {

    }

    @Test
    public void deletePostTest() {

    }
}
