package pl.piwowarski.socialmediabackend.service.postReaction;

import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;

public interface PostReactionService {

    void addPostLike(AddReactionDto addReactionDto);
    void addPostDislike(AddReactionDto addReactionDto);
    GetReactionDto getPostLikes(long id);
    GetReactionDto getPostDislikes(long id);
}
