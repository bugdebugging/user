DROP TABLE IF EXISTS users;

create table users
(
    id               bigint      NOT NULL AUTO_INCREMENT,
    username         varchar(64) NOT NULL,
    password         varchar(64) NOT NULL,
    accumulate_score int         NOT NULL default 0,
    rank             varchar(20) NOT NULL,
    created_at       datetime    NOT NULL default NOW(),
    updated_at       datetime    NOT NULL default NOW()
);