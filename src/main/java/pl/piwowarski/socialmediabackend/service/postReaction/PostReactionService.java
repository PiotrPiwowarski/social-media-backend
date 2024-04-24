package pl.piwowarski.socialmediabackend.service.postReaction;

import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;

public interface PostReactionService {

    void addPostReaction(AddReactionDto addReactionDto);
    int getPostLikes(long id);
    int getPostDislikes(long id);
}
