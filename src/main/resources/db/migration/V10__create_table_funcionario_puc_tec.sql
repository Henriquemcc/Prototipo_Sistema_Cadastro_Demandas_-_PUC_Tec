create table funcionario_puc_tec (
    id bigint not null auto_increment,
    pessoa_id bigint,
    primary key (id),
    foreign key (pessoa_id) references pessoa(id)
);