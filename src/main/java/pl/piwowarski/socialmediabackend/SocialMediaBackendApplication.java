package pl.piwowarski.socialmediabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class SocialMediaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaBackendApplication.class, args);
    }

}
