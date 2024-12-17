create table pessoa_role(
    id bigint not null auto_increment,
    pessoa_id bigint not null,
    role_id bigint not null,
    primary key(id),
    foreign key(pessoa_id) references pessoa(id),
    foreign key(role_id) references role(id)
);