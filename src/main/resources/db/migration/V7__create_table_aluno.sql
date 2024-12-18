create table aluno (
        id bigint not null auto_increment,
        curso varchar(100),
        matricula varchar(10),
        pessoa_id bigint,
        primary key (id),
        foreign key pessoa_id references pessoa(id)
)