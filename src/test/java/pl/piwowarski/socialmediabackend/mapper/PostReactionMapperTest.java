package pl.piwowarski.socialmediabackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.reaction.AddReactionDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.entity.PostReaction;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.enums.ReactionType;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

public class PostReactionMapperTest {

    private final PostService postService = Mockito.mock(PostService.class);
    private final UserService userService = Mockito.mock(UserService.class);
    private final AddReactionDto addReactionDto = AddReactionDto.builder()
            .userId(1L)
            .structureId(1L)
            .reactionType(ReactionType.LIKE)
            .build();
    private final Post post = Post.builder()
            .id(1L)
            .content("content")
            .build();
    private final User user = User.builder()
            .id(1L)
            .build();
    private final PostReaction postReaction = PostReaction.builder()
            .post(post)
            .user(user)
            .reactionType(ReactionType.LIKE)
            .build();

    @Test
    public void postReactionMapperAddReactionDtoToPostReaction() {
        Mockito.when(postService.getEntity(1L)).thenReturn(post);
        Mockito.when(userService.getEntity(1L)).thenReturn(user);

        PostReaction mappedPostReaction = PostReactionMapper.map(addReactionDto, postService, userService);

        Assertions.assertEquals(postReaction, mappedPostReaction);
    }
}
