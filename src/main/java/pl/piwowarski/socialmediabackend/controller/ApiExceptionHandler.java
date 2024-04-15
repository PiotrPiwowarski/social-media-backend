package pl.piwowarski.socialmediabackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.piwowarski.socialmediabackend.exception.NoUsersWithSuchIdException;
import pl.piwowarski.socialmediabackend.exception.UserAlreadyExistsException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handle(UserAlreadyExistsException userAlreadyExistsException) {
        return new ResponseEntity<>(userAlreadyExistsException.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoUsersWithSuchIdException.class)
    public ResponseEntity<String> handle(NoUsersWithSuchIdException noUsersWithSuchIdException) {
        return new ResponseEntity<>(noUsersWithSuchIdException.getMessage(), HttpStatus.CONFLICT);
    }
}
