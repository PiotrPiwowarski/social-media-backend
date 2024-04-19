package pl.piwowarski.socialmediabackend.mapper;

import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.AddPostDto;
import pl.piwowarski.socialmediabackend.dto.GetCommentDto;
import pl.piwowarski.socialmediabackend.dto.GetPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PostMapper {

    public static Post map(AddPostDto addPostDto, UserService userService) {
        return Post.builder()
                .content(addPostDto.getContent())
                .dateTime(LocalDateTime.now())
                .user(userService.getEntity(addPostDto.getUserId()))
                .build();
    }

    public static GetPostDto map(Post post, List<GetCommentDto> getCommentsDto) {
        return GetPostDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .likes(post.getLikes())
                .dislikes(post.getDislikes())
                .dateTime(post.getDateTime())
                .userFirstName(post.getUser().getFirstName())
                .userLastName(post.getUser().getLastName())
                .userId(post.getUser().getId())
                .comments(getCommentsDto)
                .build();
    }
}
