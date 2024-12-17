create table pessoa(
    id bigint not null auto_increment,
    nome varchar(100),
    sobrenome varchar(100),
    telefone varchar(15),
    email varchar(254),
    cpf varchar(14),
    senha text,
    primary key(id)
);