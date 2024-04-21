package pl.piwowarski.socialmediabackend.service.reaction;

import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;

public interface ReactionService {

    void addCommentLike(AddReactionDto addReactionDto);
    void addCommentDislike(AddReactionDto addReactionDto);
    void addPostLike(AddReactionDto addReactionDto);
    void addPostDislike(AddReactionDto addReactionDto);
    GetReactionDto getCommentLikes(long id);
    GetReactionDto getCommentDislikes(long id);
    GetReactionDto getPostLikes(long id);
    GetReactionDto getPostDislikes(long id);
}
