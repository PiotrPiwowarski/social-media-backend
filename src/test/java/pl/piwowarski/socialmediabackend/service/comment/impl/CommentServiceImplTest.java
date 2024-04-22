package pl.piwowarski.socialmediabackend.service.comment.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.comment.AddCommentDto;
import pl.piwowarski.socialmediabackend.entity.Comment;
import pl.piwowarski.socialmediabackend.mapper.CommentMapper;
import pl.piwowarski.socialmediabackend.repository.CommentRepository;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

public class CommentServiceImplTest {

    private final CommentRepository commentRepository = Mockito.mock(CommentRepository.class);
    private final UserService userService = Mockito.mock(UserService.class);
    private final PostService postService = Mockito.mock(PostService.class);
    private final CommentService commentService = new CommentServiceImpl(commentRepository, userService, postService);
    private final AddCommentDto addCommentDto1 = AddCommentDto.builder()
            .userId(1L)
            .postId(1L)
            .content("content")
            .build();
    private final Comment comment1 = Comment.builder()
            .content("content")
            .build();
    private final Comment comment2 = Comment.builder()
            .id(1L)
            .content("content")
            .build();

    @Test
    public void addCommentTest() {
        Mockito.when(commentRepository.save(comment1)).thenReturn(comment2);

        try(var mock = Mockito.mockStatic(CommentMapper.class)) {
            Mockito.when(CommentMapper.map(addCommentDto1, userService, postService)).thenReturn(comment1);

            Assertions.assertEquals(1L, commentService.addComment(addCommentDto1));
        }
    }
}
