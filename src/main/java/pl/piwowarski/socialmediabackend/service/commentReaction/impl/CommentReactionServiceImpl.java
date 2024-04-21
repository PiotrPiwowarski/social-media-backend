package pl.piwowarski.socialmediabackend.service.commentReaction.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.entity.CommentReaction;
import pl.piwowarski.socialmediabackend.enums.ReactionType;
import pl.piwowarski.socialmediabackend.mapper.CommentReactionMapper;
import pl.piwowarski.socialmediabackend.repository.CommentReactionRepository;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.commentReaction.CommentReactionService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentReactionServiceImpl implements CommentReactionService {

    private final CommentReactionRepository commentReactionRepository;
    private final CommentService commentService;
    private final UserService userService;

    @Override
    public void addCommentReaction(AddReactionDto addReactionDto) {
        Optional<CommentReaction> optional = commentReactionRepository
                .findByUserIdAndCommentId(addReactionDto.getUserId(), addReactionDto.getStructureId());
        if(optional.isEmpty()) {
            commentReactionRepository.save(CommentReactionMapper.map(addReactionDto, commentService, userService));
        } else {
            commentReactionRepository.delete(optional.get());
        }
    }

    @Override
    public GetReactionDto getCommentLikes(long id) {
        int likes =  commentReactionRepository.countAllByCommentIdAndReactionType(id, ReactionType.LIKE);
        return GetReactionDto.builder()
                .number(likes)
                .build();
    }

    @Override
    public GetReactionDto getCommentDislikes(long id) {
        int dislikes =  commentReactionRepository.countAllByCommentIdAndReactionType(id, ReactionType.DISLIKE);
        return GetReactionDto.builder()
                .number(dislikes)
                .build();
    }
}
