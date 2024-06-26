package pl.piwowarski.socialmediabackend.service.commentReaction.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.repository.CommentReactionRepository;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.commentReaction.CommentReactionService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

public class CommentReactionServiceImplTest {

    private final CommentReactionRepository commentReactionRepository = Mockito.mock(CommentReactionRepository.class);
    private final CommentService commentService = Mockito.mock(CommentService.class);
    private final UserService userService = Mockito.mock(UserService.class);
    private final CommentReactionService commentReactionService =
            new CommentReactionServiceImpl(commentReactionRepository, commentService, userService);
    private final GetReactionDto getReactionDto = GetReactionDto.builder()
            .number(1)
            .build();

    @Test
    public void addCommentReactionTest() {

    }

    @Test
    public void getCommentLikesTest() {

    }

    @Test
    public void getCommentDislikesTest() {

    }
}
