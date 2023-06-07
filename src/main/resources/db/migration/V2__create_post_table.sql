create table if not exists post
(
    id bigint auto_increment primary key,
    title varchar(300) not null,
    content text not null,
    user_id bigint references users (id),
    created_at timestamp not null
);