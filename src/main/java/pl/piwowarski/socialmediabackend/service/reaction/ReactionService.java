package pl.piwowarski.socialmediabackend.service.reaction;

import pl.piwowarski.socialmediabackend.dto.reaction.CommentDislikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentLikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.PostDislikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.PostLikeDto;

public interface ReactionService {

    void addCommentLike(CommentLikeDto commentLikeDto);
    void addCommentDislike(CommentDislikeDto commentDislikeDto);
    void addPostLike(PostLikeDto postLikeDto);
    void addPostDislike(PostDislikeDto postDislikeDto);
}
