CREATE TABLE IF NOT EXISTS users(
    id bigint auto_increment primary key,
    firstName varchar(64) not null,
    lastName varchar(64) not null,
    email varchar(256) not null,
    password varchar(256) not null
);