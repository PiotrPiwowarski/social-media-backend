package pl.piwowarski.socialmediabackend.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NoUsersWithSuchIdException extends RuntimeException {

    private String message;
}
