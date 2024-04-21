package pl.piwowarski.socialmediabackend.service.comment;

import pl.piwowarski.socialmediabackend.dto.comment.AddCommentDto;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentDislikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentLikeDto;
import pl.piwowarski.socialmediabackend.entity.Comment;

import java.util.List;

public interface CommentService {

    long addComment(AddCommentDto addCommentDto);
    List<Comment> getPostComments(long postId);
    void deleteComment(long id, long userId);
}
