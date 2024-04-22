package pl.piwowarski.socialmediabackend.provider;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.post.AddPostDto;
import pl.piwowarski.socialmediabackend.entity.Post;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestPostDataProvider {

    public static AddPostDto addPostDto1 = AddPostDto.builder()
            .userId(1L)
            .content("content")
            .build();

    public static Post post1 = Post.builder()
            .content("content")
            .build();

    public static Post post2 = Post.builder()
            .id(1L)
            .content("content")
            .build();
}
