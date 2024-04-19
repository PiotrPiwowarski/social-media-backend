package pl.piwowarski.socialmediabackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NoUsersWithSuchIdException extends RuntimeException {

    private String message;
}
