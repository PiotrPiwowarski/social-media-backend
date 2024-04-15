CREATE TABLE IF NOT EXISTS users (
    id bigint auto_increment primary key,
    first_name varchar(64) not null,
    last_name varchar(64) not null,
    email varchar(256) not null,
    password varchar(256) not null
);

CREATE TABLE IF NOT EXISTS followed_users (
    id bigint auto_increment primary key,
    user_id bigint not null references users(id),
    followed_user_id bigint not null references users(id)
);