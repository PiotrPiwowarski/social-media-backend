package pl.piwowarski.socialmediabackend.service.commentReaction.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.repository.CommentReactionRepository;
import pl.piwowarski.socialmediabackend.service.commentReaction.CommentReactionService;

@RequiredArgsConstructor
@Service
public class CommentReactionServiceImpl implements CommentReactionService {

    private final CommentReactionRepository commentReactionRepository;

    @Override
    public void addCommentLike(AddReactionDto addReactionDto) {

    }

    @Override
    public void addCommentDislike(AddReactionDto addReactionDto) {

    }

    @Override
    public GetReactionDto getCommentLikes(long id) {
        return null;
    }

    @Override
    public GetReactionDto getCommentDislikes(long id) {
        return null;
    }
}
