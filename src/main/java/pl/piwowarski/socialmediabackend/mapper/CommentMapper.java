package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.comment.AddCommentDto;
import pl.piwowarski.socialmediabackend.dto.comment.GetCommentDto;
import pl.piwowarski.socialmediabackend.entity.Comment;
import pl.piwowarski.socialmediabackend.service.post.PostService;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class CommentMapper {

    public static Comment map(AddCommentDto addCommentDto, UserService userService, PostService postService) {
        return Comment.builder()
                .content(addCommentDto.getContent())
                .dateTime(LocalDateTime.now())
                .user(userService.getEntity(addCommentDto.getUserId()))
                .post(postService.getEntity(addCommentDto.getPostId()))
                .build();
    }

    public static GetCommentDto map(Comment comment) {
        return GetCommentDto.builder()
                .id(comment.getId())
                .likes(comment.getLikes())
                .dislikes(comment.getDislikes())
                .content(comment.getContent())
                .dateTime(comment.getDateTime())
                .postId(comment.getPost().getId())
                .userId(comment.getUser().getId())
                .userFirstName(comment.getUser().getFirstName())
                .userLastName(comment.getUser().getLastName())
                .build();
    }
}
