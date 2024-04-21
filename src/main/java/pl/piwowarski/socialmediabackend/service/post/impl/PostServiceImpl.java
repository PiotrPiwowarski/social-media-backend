package pl.piwowarski.socialmediabackend.service.post.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.post.AddPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.exception.NoPostsWithSuchId;
import pl.piwowarski.socialmediabackend.mapper.PostMapper;
import pl.piwowarski.socialmediabackend.repository.PostRepository;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public long addPost(AddPostDto addPostDto) {
        Post post = postRepository.save(PostMapper.map(addPostDto, userService));
        return post.getId();
    }

    @Override
    public Post getEntity(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NoPostsWithSuchId("Brak postów o podanym id"));
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(long id, long userId) {
        postRepository.deleteByIdAndUserId(id, userId);
    }
}
