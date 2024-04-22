package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.entity.CommentReaction;
import pl.piwowarski.socialmediabackend.enums.ReactionType;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

public class CommentReactionMapperTest {

    private final CommentService commentService = Mockito.mock(CommentService.class);
    private final UserService userService = Mockito.mock(UserService.class);
    private final AddReactionDto addReactionDto = AddReactionDto.builder()
            .userId(1L)
            .structureId(1L)
            .reactionType(ReactionType.LIKE)
            .build();
    private final CommentReaction commentReaction = CommentReaction.builder()
            .comment(null)
            .reactionType(ReactionType.LIKE)
            .user(null)
            .build();


    @Test
    public void CommentReactionMapperAddReactionDtoToCommentReactionTest() {
        Mockito.when(commentService.getEntity(1L)).thenReturn(null);
        Mockito.when(userService.getEntity(1L)).thenReturn(null);

        CommentReaction mappedCommentReaction = CommentReactionMapper.map(addReactionDto, commentService, userService);

        Assertions.assertEquals(commentReaction, mappedCommentReaction);
    }
}
