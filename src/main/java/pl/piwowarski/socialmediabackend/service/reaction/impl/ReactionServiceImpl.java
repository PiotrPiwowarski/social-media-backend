package pl.piwowarski.socialmediabackend.service.reaction.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.repository.CommentReactionRepository;
import pl.piwowarski.socialmediabackend.repository.PostReactionRepository;
import pl.piwowarski.socialmediabackend.service.reaction.ReactionService;

@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private final CommentReactionRepository commentReactionRepository;
    private final PostReactionRepository postReactionRepository;

    @Override
    public void addCommentLike(AddReactionDto addReactionDto) {

    }

    @Override
    public void addCommentDislike(AddReactionDto addReactionDto) {

    }

    @Override
    public void addPostLike(AddReactionDto addReactionDto) {

    }

    @Override
    public void addPostDislike(AddReactionDto addReactionDto) {

    }

    @Override
    public GetReactionDto getCommentLikes(long id) {
        return null;
    }

    @Override
    public GetReactionDto getCommentDislikes(long id) {
        return null;
    }

    @Override
    public GetReactionDto getPostLikes(long id) {
        return null;
    }

    @Override
    public GetReactionDto getPostDislikes(long id) {
        return null;
    }
}
