package pl.piwowarski.socialmediabackend.service.postsWithComments.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.GetCommentDto;
import pl.piwowarski.socialmediabackend.dto.GetPostDto;
import pl.piwowarski.socialmediabackend.mapper.CommentMapper;
import pl.piwowarski.socialmediabackend.mapper.PostMapper;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.postsWithComments.PostsWithCommentsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsWithCommentsServiceImpl implements PostsWithCommentsService {

    private final PostService postService;
    private final CommentService commentService;

    @Override
    public List<GetPostDto> getAllPostsWithComments() {
        return postService.getAllPosts().stream().map(post -> getPostDto(post.getId())).toList();
    }

    private GetPostDto getPostDto(long id) {
        List<GetCommentDto> getComments = commentService
                .getPostComments(id).stream().map(CommentMapper::map)
                .toList();
        return PostMapper.map(postService.getEntity(id), getComments);
    }
}
