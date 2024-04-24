package pl.piwowarski.socialmediabackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NoUsersWithSuchEmail extends RuntimeException {

    private String message;
}
