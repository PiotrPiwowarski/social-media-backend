package pl.piwowarski.socialmediabackend.service.postsWithComments;

import pl.piwowarski.socialmediabackend.dto.GetPostDto;

import java.util.List;

public interface PostsWithCommentsService {

    List<GetPostDto> getAllPostsWithComments();
}
