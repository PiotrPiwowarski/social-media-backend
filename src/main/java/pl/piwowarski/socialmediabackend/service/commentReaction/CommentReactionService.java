package pl.piwowarski.socialmediabackend.service.commentReaction;

import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;

public interface CommentReactionService {

    void addCommentReaction(AddReactionDto addReactionDto);
    GetReactionDto getCommentLikes(long id);
    GetReactionDto getCommentDislikes(long id);
}
