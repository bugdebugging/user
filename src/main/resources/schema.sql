DROP TABLE IF EXISTS users;

create table users
(
    id         bigint      NOT NULL AUTO_INCREMENT,
    username   varchar(64) NOT NULL,
    password   varchar(64) NOT NULL,
    rank       varchar(20) NOT NULL,
    created_at datetime    NOT NULL default NOW(),
    updated_at datetime    NOT NULL default NOW()
);