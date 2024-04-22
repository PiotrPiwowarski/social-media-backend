INSERT INTO users (first_name, last_name, email, password)
values ('Admin', 'Admin', 'admin@gmail.com', 'admin');

INSERT INTO users (first_name, last_name, email, password)
values ('Pedro', 'Pedrowski', 'pedro@gmail.com', 'pedro');

INSERT INTO users (first_name, last_name, email, password)
values ('Pablo', 'Pablowski', 'pablo@gmail.com', 'pablo');

INSERT INTO followed_users (user_id, followed_user_id)
values (1, 2);

INSERT INTO followed_users (user_id, followed_user_id)
values (1, 3);

INSERT INTO followed_users (user_id, followed_user_id)
values (2, 3);

INSERT INTO posts (content, date_time, user_id)
values ('hello post', '2024-01-07 12:24:36', 1);

INSERT INTO posts (content, date_time, user_id)
values ('goodbye post', '2024-01-07 12:24:36', 2);

INSERT INTO posts (content, date_time, user_id)
values ('nice post', '2024-01-07 12:24:36', 3);

INSERT INTO posts (content, date_time, user_id)
values ('bad post', '2024-01-07 12:24:36', 3);

INSERT INTO comments (content, date_time, user_id, post_id)
values ('super', '2024-01-07 12:24:36', 1, 1);

INSERT INTO comments (content, date_time,user_id, post_id)
values ('great', '2024-01-07 12:24:36', 1, 1);

INSERT INTO comments (content, date_time,user_id, post_id)
values ('not bad', '2024-01-07 12:24:36', 2, 2);

INSERT INTO comments (content, date_time,user_id, post_id)
values ('sorry', '2024-01-07 12:24:36', 3, 3);

INSERT INTO comments (content, date_time,user_id, post_id)
values ('fine', '2024-01-07 12:24:36', 2, 4);

INSERT INTO comments (content, date_time,user_id, post_id)
values ('can be better', '2024-01-07 12:24:36', 3, 4);