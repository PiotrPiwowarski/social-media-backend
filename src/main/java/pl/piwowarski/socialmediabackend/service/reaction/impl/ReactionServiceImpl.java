package pl.piwowarski.socialmediabackend.service.reaction.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentDislikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.CommentLikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.PostDislikeDto;
import pl.piwowarski.socialmediabackend.dto.reaction.PostLikeDto;
import pl.piwowarski.socialmediabackend.repository.CommentReactionRepository;
import pl.piwowarski.socialmediabackend.repository.PostReactionRepository;
import pl.piwowarski.socialmediabackend.service.reaction.ReactionService;

@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private final CommentReactionRepository commentReactionRepository;
    private final PostReactionRepository postReactionRepository;

    @Override
    public void addCommentLike(CommentLikeDto commentLikeDto) {

    }

    @Override
    public void addCommentDislike(CommentDislikeDto commentDislikeDto) {

    }

    @Override
    public void addPostLike(PostLikeDto postLikeDto) {

    }

    @Override
    public void addPostDislike(PostDislikeDto postDislikeDto) {

    }
}
