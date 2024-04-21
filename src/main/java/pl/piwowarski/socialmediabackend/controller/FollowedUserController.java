package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.followUser.AddFollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.followUser.GetFollowedUserDto;
import pl.piwowarski.socialmediabackend.service.followedUser.FollowedUserService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/followedUsers")
public class FollowedUserController {

    private final FollowedUserService followedUserService;

    @PostMapping
    public ResponseEntity<Void> addUserToFollowers(@RequestBody AddFollowedUserDto addFollowedUserDto) {
        long id = followedUserService.addUserToFollowers(addFollowedUserDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<GetFollowedUserDto>> getAllFollowedUsers(@PathVariable long userId) {
        List<GetFollowedUserDto> getFollowedUsers = followedUserService.getFollowedUsers(userId);
        return ResponseEntity.ok(getFollowedUsers);
    }

    @DeleteMapping("/{userId}/{followedUserId}")
    public ResponseEntity<Void> deleteUserFromFollowers(@PathVariable long userId, @PathVariable long followedUserId) {
        followedUserService.deleteUserFromFollowers(userId, followedUserId);
		return ResponseEntity.ok().build();
    }
}
