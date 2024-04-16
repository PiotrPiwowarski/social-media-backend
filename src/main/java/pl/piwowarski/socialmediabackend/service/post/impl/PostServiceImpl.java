package pl.piwowarski.socialmediabackend.service.post.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.repository.PostRepository;
import pl.piwowarski.socialmediabackend.service.post.PostService;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
}
