package pl.piwowarski.socialmediabackend.service.commentReaction;

import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;

public interface CommentReactionService {

    void addCommentLike(AddReactionDto addReactionDto);
    void addCommentDislike(AddReactionDto addReactionDto);
    GetReactionDto getCommentLikes(long id);
    GetReactionDto getCommentDislikes(long id);
}
