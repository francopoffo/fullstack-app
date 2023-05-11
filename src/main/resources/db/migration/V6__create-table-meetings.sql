create table meetings(

    id bigint not null auto_increment,
    user_id bigint not null,
    date_time datetime not null,

    primary key(id),
    constraint fk_meetings_user_id foreign key(user_id) references users(id)

);