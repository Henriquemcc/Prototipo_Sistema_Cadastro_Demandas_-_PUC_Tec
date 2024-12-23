create table professor(
    id bigint not null auto_increment,
    area_id bigint,
    pessoa_id bigint,
    primary key(id),
    foreign key (pessoa_id) references pessoa(id),
    foreign key (area_id) references area(id)
);