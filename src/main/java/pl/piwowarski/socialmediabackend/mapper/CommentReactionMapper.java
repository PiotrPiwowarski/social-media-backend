package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.entity.CommentReaction;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class CommentReactionMapper {

    public static CommentReaction map(AddReactionDto addReactionDto,
                                      CommentService commentService,
                                      UserService userService) {
        return CommentReaction.builder()
                .comment(commentService.getEntity(addReactionDto.getStructureId()))
                .user(userService.getEntity(addReactionDto.getUserId()))
                .reactionType(addReactionDto.getReactionType())
                .build();
    }
}
