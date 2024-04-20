INSERT INTO users (first_name, last_name, email, password)
values ('Admin', 'Admin', 'admin@gmail.com', 'admin');

INSERT INTO users (first_name, last_name, email, password)
values ('Pedro', 'Pedrowski', 'pedro@gmail.com', 'pedro');

INSERT INTO users (first_name, last_name, email, password)
values ('Pablo', 'Pablowski', 'pablo@gmail.com', 'pablo');

INSERT INTO followed_users (user_id, followed_user_id)
values (1, 2);

INSERT INTO followed_users (user_id, followed_user_id)
values (2, 3);

INSERT INTO posts (content, date_time, user_id, likes, dislikes)
values ('hello post', '2024-01-07 12:24:36', 1, 10, 4);

INSERT INTO posts (content, date_time, user_id, likes, dislikes)
values ('goodbye post', '2024-01-07 12:24:36', 2, 10, 4);

INSERT INTO posts (content, date_time, user_id, likes, dislikes)
values ('nice post', '2024-01-07 12:24:36', 3, 10, 4);

INSERT INTO posts (content, date_time, user_id, likes, dislikes)
values ('bad post', '2024-01-07 12:24:36', 3, 10, 4);

INSERT INTO comments (content, date_time, user_id, post_id, likes, dislikes)
values ('super', '2024-01-07 12:24:36', 1, 1, 10, 4);

INSERT INTO comments (content, date_time,user_id, post_id, likes, dislikes)
values ('great', '2024-01-07 12:24:36', 1, 1, 10, 4);

INSERT INTO comments (content, date_time,user_id, post_id, likes, dislikes)
values ('not bad', '2024-01-07 12:24:36', 2, 2, 10, 4);

INSERT INTO comments (content, date_time,user_id, post_id, likes, dislikes)
values ('sorry', '2024-01-07 12:24:36', 3, 3, 10, 4);

INSERT INTO comments (content, date_time,user_id, post_id, likes, dislikes)
values ('fine', '2024-01-07 12:24:36', 2, 4, 10, 4);

INSERT INTO comments (content, date_time,user_id, post_id, likes, dislikes)
values ('can be better', '2024-01-07 12:24:36', 3, 4, 10, 4);