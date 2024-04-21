package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.entity.PostReaction;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PostReactionMapper {

    public static PostReaction map(AddReactionDto addReactionDto,
                                   PostService postService,
                                   UserService userService) {
        return PostReaction.builder()
                .post(postService.getEntity(addReactionDto.getStructureId()))
                .user(userService.getEntity(addReactionDto.getUserId()))
                .reactionType(addReactionDto.getReactionType())
                .build();
    }
}
