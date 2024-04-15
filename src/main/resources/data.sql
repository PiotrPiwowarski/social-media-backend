INSERT INTO users (first_name, last_name, email, password) values ('Admin', 'Admin', 'admin@gmail.com', 'admin');
INSERT INTO users (first_name, last_name, email, password) values ('Pedro', 'Pedrowski', 'pedro@gmail.com', 'pedro');
INSERT INTO users (first_name, last_name, email, password) values ('Pablo', 'Pablowski', 'pablo@gmail.com', 'pablo');

INSERT INTO followed_users (user_id, followed_user_id) values (1, 2);
INSERT INTO followed_users (user_id, followed_user_id) values (1, 3);