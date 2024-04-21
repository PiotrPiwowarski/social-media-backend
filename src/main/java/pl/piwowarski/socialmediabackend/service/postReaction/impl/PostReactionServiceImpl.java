package pl.piwowarski.socialmediabackend.service.postReaction.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.entity.CommentReaction;
import pl.piwowarski.socialmediabackend.entity.PostReaction;
import pl.piwowarski.socialmediabackend.mapper.CommentReactionMapper;
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
    public void addPostLike(AddReactionDto addReactionDto) {
        Optional<PostReaction> optional = postReactionRepository
                .findByUserIdAndPostId(addReactionDto.getUserId(), addReactionDto.getStructureId());
        if(optional.isEmpty()) {
            postReactionRepository.save(PostReactionMapper.map(addReactionDto, postService, userService));
        } else {
            postReactionRepository.delete(optional.get());
        }
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
