# Fast Typing App - Backend
This app helps user to improve his typing skills. User selects length of the text and try to rewrite it without making mistakes
and as fast as possible. After rewriting the text, user can check statistics.

## Introduction
This project contains API of the application

## Technologies
This Rest API is created using following technologies:
* Java 17
* Spring Boot
* Spring data
* H2 database
* Lombok
* JUnit
* Mockito

## Database
* H2

I decided to use H2 database that only runs at runtime. This solution is sufficient for purposes of demonstration.

There are two .sql files in `src/main/resources`:
* `schema.sql` - it is used to build the database in runtime
* `data.sql` - it fills the database with data

## Running the application
### Using Docker
1. Go to the main application folder
2. Use following command in terminal:

```
docker compose up
```

3. Use following URL in your browser:

```
http://localhost:3000
```

## API Documentation
### HTTP POST -> /api/users
* Adding new user
* Request Body Object must contain: firstName, lastName, email, password

### HTTP GET -> /api/users
* Getting list of users

### HTTP GET -> /api/users/{id}
* Getting user by id

### HTTP DELETE -> /api/users
* Removing user by id

### HTTP POST -> /api/followedUsers
* Adding user to follow list
* Request Body Object must contain: userId, followedUserId

### HTTP GET -> /api/followedUsers/{id}
* Getting list of followed users

### HTTP DELETE -> /api/followedUsers/{id}
* Removing user from followed users list

### HTTP POST -> /api/posts
* Adding new post
* Request Body Object must contain: content, userId

### HTTP DELETE -> /api/posts/{id}/user/{userId}
* Removing post by id and userId

### HTTP POST -> /api/comments
* Adding new comment
* Request Body Object must contain: content, userId, postId

### HTTP DELETE -> /api/comments/{id}/user/{userId}
* Removing comment by id and userId

### HTTP GET -> /api/postsWithComments
* Getting list of all posts with their comments

### HTTP GET -> /api/postsWithComments/{userId}/followedUsers
* Getting list of followed users posts with their comments
