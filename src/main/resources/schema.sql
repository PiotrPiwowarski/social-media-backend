CREATE TABLE IF NOT EXISTS users (
    id bigint auto_increment primary key,
    first_name varchar(64) not null,
    last_name varchar(64) not null,
    email varchar(256) not null,
    password varchar(256) not null
);

CREATE TABLE IF NOT EXISTS followed_users (
    id bigint auto_increment primary key,
    user_id bigint references users(id) on delete cascade,
    followed_user_id bigint references users(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS posts (
    id bigint auto_increment primary key,
    content varchar(256) not null,
    date_time timestamp not null,
    user_id bigint references users(id) on delete cascade,
    likes bigint not null default 0,
    dislikes bigint not null default 0
);

CREATE TABLE IF NOT EXISTS comments (
    id bigint auto_increment primary key,
    content varchar(256) not null,
    date_time timestamp not null,
    user_id bigint references users(id) on delete cascade,
    post_id bigint references posts(id) on delete cascade,
    likes bigint not null default 0,
    dislikes bigint not null default 0
);