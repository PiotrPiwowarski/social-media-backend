package pl.piwowarski.socialmediabackend.service.comment.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.comment.AddCommentDto;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentDislikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentLikeDto;
import pl.piwowarski.socialmediabackend.entity.Comment;
import pl.piwowarski.socialmediabackend.mapper.CommentMapper;
import pl.piwowarski.socialmediabackend.repository.CommentRepository;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    @Override
    public long addComment(AddCommentDto addCommentDto) {
        Comment comment = commentRepository.save(CommentMapper.map(addCommentDto, userService, postService));
        return comment.getId();
    }

    @Override
    public List<Comment> getPostComments(long postId) {
        return commentRepository
                .findAllByPostId(postId);
    }

    @Override
    public void deleteComment(long id, long userId) {
        commentRepository.deleteByIdAndUserId(id, userId);
    }
}
