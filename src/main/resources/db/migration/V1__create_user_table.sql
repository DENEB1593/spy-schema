create table if not exists users (
    id bigint auto_increment primary key,
    name varchar(100) not null,
    created_at timestamp not null
);