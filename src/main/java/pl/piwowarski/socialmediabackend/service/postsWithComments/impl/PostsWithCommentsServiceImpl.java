package pl.piwowarski.socialmediabackend.service.postsWithComments.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.comment.GetCommentDto;
import pl.piwowarski.socialmediabackend.dto.followUser.GetFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.post.GetPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.mapper.CommentMapper;
import pl.piwowarski.socialmediabackend.mapper.PostMapper;
import pl.piwowarski.socialmediabackend.service.comment.CommentService;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.postsWithComments.PostsWithCommentsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsWithCommentsServiceImpl implements PostsWithCommentsService {

    private final FollowedUserService followedUserService;
    private final PostService postService;
    private final CommentService commentService;

    @Override
    public List<GetPostDto> getAllPostsWithComments() {
        return postService.getAllPosts()
                .stream()
                .map(post -> getPostDto(post.getId()))
                .toList();
    }

    private GetPostDto getPostDto(long id) {
        List<GetCommentDto> getComments = commentService
                .getPostComments(id)
                .stream()
                .map(CommentMapper::map)
                .toList();
        return PostMapper.map(postService.getEntity(id), getComments);
    }

    @Override
    public List<GetPostDto> getFollowedUsersPostsWithComments(long userId) {
        List<GetFollowedUserDto> followedUsers = followedUserService.getFollowedUsers(userId);
        return postService.getAllPosts()
                .stream()
                .filter(post -> filterFollowedUsersPosts(post, followedUsers))
                .map(post -> getPostDto(post.getId()))
                .toList();
    }

    private boolean filterFollowedUsersPosts(Post post, List<GetFollowedUserDto> followedUsers) {
        for (GetFollowedUserDto followedUser : followedUsers) {
            if (post.getUser().getId().equals(followedUser.getFollowedUserId())) {
                return true;
            }
        }
        return false;
    }
}
