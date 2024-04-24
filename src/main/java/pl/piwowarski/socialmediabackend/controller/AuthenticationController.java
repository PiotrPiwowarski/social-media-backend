package pl.piwowarski.socialmediabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.socialmediabackend.dto.user.LoginResponse;
import pl.piwowarski.socialmediabackend.dto.user.LoginUserDto;
import pl.piwowarski.socialmediabackend.security.service.login.LoginService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authentication(@RequestBody LoginUserDto loginUserDto) {
        LoginResponse loginResponse = loginService.authenticate(loginUserDto);

        return ResponseEntity.ok(loginResponse);
    }
}
