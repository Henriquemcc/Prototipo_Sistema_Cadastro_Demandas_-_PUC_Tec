create table startup (
    id bigint not null auto_increment,
    cnpj varchar(255),
    nome varchar(255),
    ano integer,
    semestre tinyint,
    primary key (id)
);