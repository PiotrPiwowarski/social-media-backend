package pl.piwowarski.socialmediabackend.service.postReaction.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.socialmediabackend.dto.reaction.GetReactionDto;
import pl.piwowarski.socialmediabackend.repository.PostReactionRepository;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.postReaction.PostReactionService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

public class PostReactionImplTest {

    private final PostReactionRepository postReactionRepository = Mockito.mock(PostReactionRepository.class);
    private final PostService postService = Mockito.mock(PostService.class);
    private final UserService userService = Mockito.mock(UserService.class);
    private final PostReactionService postReactionService =
            new PostReactionServiceImpl(postReactionRepository, postService, userService);
    private final GetReactionDto getReactionDto = GetReactionDto.builder()
            .number(1)
            .build();

    @Test
    public void getPostLikesTest() {

    }
}
