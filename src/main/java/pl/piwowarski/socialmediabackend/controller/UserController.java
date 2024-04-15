package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import pl.piwowarski.socialmediabackend.dto.AddUserDto;
import pl.piwowarski.socialmediabackend.service.UserService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
	public ResponseEntity<Void> addUser(@RequestBody AddUserDto addUserDto) {
        long userId = userService.addUser(addUserDto);
        URI uri = URI.create(String.valueOf(userId));
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
