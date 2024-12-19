create table funcionario_startup (
    id bigint not null auto_increment,
    pessoa_id bigint,
    startup_id bigint,
    primary key (id),
    foreign key pessoa_id references pessoa(id),
    foreign key startup_id references startup(id)
);