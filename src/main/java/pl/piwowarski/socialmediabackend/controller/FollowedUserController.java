package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.FollowedUserDto;
import pl.piwowarski.socialmediabackend.dto.GetFollowedUserDto;
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
    public ResponseEntity<Void> addUserToFollowers(@RequestBody FollowedUserDto followedUserDto) {
        long id = followedUserService.addUserToFollowers(followedUserDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<GetFollowedUserDto>> getAllFollowedUsers(@PathVariable long userId) {
        List<GetFollowedUserDto> getFollowedUsers = followedUserService.getFollowedUsers(userId);
        return ResponseEntity.ok(getFollowedUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFromFollowers(@PathVariable long id) {
        followedUserService.deleteUserFromFollowers(id);
		return ResponseEntity.ok().build();
    }
}
