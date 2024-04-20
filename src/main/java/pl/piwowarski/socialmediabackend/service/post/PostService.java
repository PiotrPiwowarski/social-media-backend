package pl.piwowarski.socialmediabackend.service.post;

import pl.piwowarski.socialmediabackend.dto.AddPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;

import java.util.Collection;
import java.util.List;

public interface PostService {

    long addPost(AddPostDto addPostDto);
    Post getEntity(long id);
    List<Post> getAllPosts();
    void deletePost(long id, long userId);
}
