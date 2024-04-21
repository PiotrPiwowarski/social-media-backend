package pl.piwowarski.socialmediabackend.service.postReaction.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.entity.PostReaction;
import pl.piwowarski.socialmediabackend.repository.PostReactionRepository;
import pl.piwowarski.socialmediabackend.service.postReaction.PostReactionService;

@RequiredArgsConstructor
@Service
public class PostReactionServiceImpl implements PostReactionService {

    private final PostReactionRepository postReactionRepository;

    @Override
    public void addPostLike(AddReactionDto addReactionDto) {

    }

    @Override
    public void addPostDislike(AddReactionDto addReactionDto) {

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
