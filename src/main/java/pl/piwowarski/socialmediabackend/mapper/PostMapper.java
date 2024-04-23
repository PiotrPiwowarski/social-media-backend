package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.post.AddPostDto;
import pl.piwowarski.socialmediabackend.dto.comment.GetCommentDto;
import pl.piwowarski.socialmediabackend.dto.post.GetPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.service.postReaction.PostReactionService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PostMapper {

    public static Post map(AddPostDto addPostDto, UserService userService) {
        return Post.builder()
                .content(addPostDto.getContent())
                .dateTime(LocalDateTime.now())
                .user(userService.getEntity(addPostDto.getUserId()))
                .build();
    }

    public static GetPostDto map(Post post, PostReactionService postReactionService, List<GetCommentDto> getCommentsDto) {
        return GetPostDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .dateTime(post.getDateTime())
                .userFirstName(post.getUser().getFirstName())
                .userLastName(post.getUser().getLastName())
                .userId(post.getUser().getId())
                .likes(postReactionService.getPostLikes(post.getId()))
                .dislikes(postReactionService.getPostDislikes(post.getId()))
                .comments(getCommentsDto)
                .build();
    }
}
