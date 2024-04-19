package pl.piwowarski.socialmediabackend.service.comment;

import pl.piwowarski.socialmediabackend.dto.AddCommentDto;
import pl.piwowarski.socialmediabackend.entity.Comment;

import java.util.List;

public interface CommentService {

    long addComment(AddCommentDto addCommentDto);
    List<Comment> getPostComments(long postId);
}
