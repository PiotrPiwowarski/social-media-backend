package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.comment.AddCommentDto;
import pl.piwowarski.socialmediabackend.dto.comment.GetCommentDto;
import pl.piwowarski.socialmediabackend.entity.Comment;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.service.commentReaction.CommentReactionService;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;

public class CommentMapperTest {

    private final UserService userService = Mockito.mock(UserService.class);
    private final PostService postService = Mockito.mock(PostService.class);
    private final CommentReactionService commentReactionService = Mockito.mock(CommentReactionService.class);
    private final GetCommentDto getCommentDto = GetCommentDto.builder()
            .id(1L)
            .userId(1L)
            .postId(1L)
            .userFirstName(null)
            .userLastName(null)
            .dateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0))
            .content("content")
            .build();
    private final AddCommentDto addcommentDto = AddCommentDto.builder()
            .postId(1L)
            .content("content")
            .userId(1L)
            .build();
    private final User user = User.builder()
            .id(1L)
            .build();
    private final Post post = Post.builder()
            .id(1L)
            .build();
    private final Comment comment = Comment.builder()
            .content("content")
            .dateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0))
            .post(post)
            .user(user)
            .build();
    private final Comment comment2 = Comment.builder()
            .id(1L)
            .content("content")
            .dateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0))
            .post(post)
            .user(user)
            .build();


    @Test
    public void commentMapperAddCommentDtoToCommentTest() {
        Mockito.when(userService.getEntity(1L)).thenReturn(user);
        Mockito.when(postService.getEntity(1L)).thenReturn(post);

        Comment mappedComment = CommentMapper.map(addcommentDto, userService, postService);
        mappedComment.setDateTime(LocalDateTime.of(2024, 4, 22, 12, 0, 0));

        Assertions.assertEquals(comment, mappedComment);
    }

    @Test
    public void commentMapperCommentToGetCommentDtoTest() {
        Mockito.when(commentReactionService.getCommentDislikes(1L)).thenReturn(0);
        Mockito.when(commentReactionService.getCommentLikes(1L)).thenReturn(0);

        GetCommentDto mappedGetCommentDto = CommentMapper.map(comment2, commentReactionService);

        Assertions.assertEquals(getCommentDto, mappedGetCommentDto);
    }
}
