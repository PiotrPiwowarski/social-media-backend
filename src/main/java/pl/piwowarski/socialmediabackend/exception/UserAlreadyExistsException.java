package pl.piwowarski.socialmediabackend.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserAlreadyExistsException extends RuntimeException {

    private String message;
}
