package pl.piwowarski.socialmediabackend.service.postsWithComments;

import pl.piwowarski.socialmediabackend.dto.post.GetPostDto;

import java.util.List;

public interface PostsWithCommentsService {

    List<GetPostDto> getAllPostsWithComments();
    List<GetPostDto> getFollowedUsersPostsWithComments(long userId);
}
