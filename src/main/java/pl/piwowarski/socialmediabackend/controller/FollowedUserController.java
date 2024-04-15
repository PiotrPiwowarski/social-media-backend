package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class FollowedUserController {

    private final FollowedUserService followedUserService;

    @PostMapping("/followedUsers")
    public ResponseEntity<Void> addUserToFollowers(@RequestBody FollowedUserDto followedUserDto) {
        long id = followedUserService.addUserToFollowers(followedUserDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }
}
