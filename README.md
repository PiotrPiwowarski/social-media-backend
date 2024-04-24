# Social Media App - Backend

This project contains API of the social media app. You can create user, post, comment. Users can follow other users,
give likes and dislikes to posts and comments.

## What's next

This project is constantly being developed, new features soon!

Now it's time to test application. 

## Technologies
This Rest API is created using following technologies:
* Java 17
* Spring Boot
* Spring Data
* Spring Security
* H2 database
* Lombok
* JUnit
* Mockito

## Database
* H2

I decided to use H2 database that only runs at runtime. This solution is sufficient for purposes of demonstration.

There are two .sql files in `src/main/resources`:
* `schema.sql` - it is used to build the database at runtime
* `data.sql` - it fills the database with data

## Some functionalities
* Authentication
* Adding new user
* Getting user by id
* Getting all users
* Deleting user
* Adding user to followers
* Getting all followed users
* Deleting user from followers
* Adding new post
* Deleting post
* Adding new comment
* Deleting comment
* Adding post reaction
* Adding comment reaction
* Getting all posts with reactions and comments with reactions
* Getting followed users posts with reactions and comments with reactions


## Running the application
### Using Docker
1. Download docker image
```
docker pull piotrpiw/social-media-backend:1.0
```
2. Run docker container with app
```
docker run -p 8080:8080 piotrpiw/social-media-backend:1.0
```

