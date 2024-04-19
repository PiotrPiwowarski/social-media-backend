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

CREATE TABLE IF NOT EXISTS posts (
    id bigint auto_increment primary key,
    content varchar(256) not null,
    date_time timestamp not null,
    user_id bigint not null references users(id),
    likes bigint not null default 0,
    dislikes bigint not null default 0
);

CREATE TABLE IF NOT EXISTS comments (
    id bigint auto_increment primary key,
    content varchar(256) not null,
    date_time timestamp not null,
    user_id bigint not null references users(id),
    post_id bigint not null references posts(id),
    likes bigint not null default 0,
    dislikes bigint not null default 0
);