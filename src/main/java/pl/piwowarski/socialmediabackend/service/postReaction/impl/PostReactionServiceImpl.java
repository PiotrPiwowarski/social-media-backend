package pl.piwowarski.socialmediabackend.service.postReaction.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.entity.PostReaction;
import pl.piwowarski.socialmediabackend.enums.ReactionType;
import pl.piwowarski.socialmediabackend.mapper.PostReactionMapper;
import pl.piwowarski.socialmediabackend.repository.PostReactionRepository;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.postReaction.PostReactionService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostReactionServiceImpl implements PostReactionService {

    private final PostReactionRepository postReactionRepository;
    private final PostService postService;
    private final UserService userService;

    @Override
    public void addPostReaction(AddReactionDto addReactionDto) {
        Optional<PostReaction> optional = postReactionRepository
                .findByUserIdAndPostId(addReactionDto.getUserId(), addReactionDto.getStructureId());
        if(optional.isEmpty()) {
            postReactionRepository.save(PostReactionMapper.map(addReactionDto, postService, userService));
        } else if(optional.get().getReactionType().equals(addReactionDto.getReactionType())) {
            postReactionRepository.delete(optional.get());
        } else {
            postReactionRepository.delete(optional.get());
            postReactionRepository.save(PostReactionMapper.map(addReactionDto, postService, userService));
        }
    }

    @Override
    public int getPostLikes(long id) {
        return postReactionRepository.countAllByPostIdAndReactionType(id, ReactionType.LIKE);
    }

    @Override
    public int getPostDislikes(long id) {
        return postReactionRepository.countAllByPostIdAndReactionType(id, ReactionType.DISLIKE);
    }
}
