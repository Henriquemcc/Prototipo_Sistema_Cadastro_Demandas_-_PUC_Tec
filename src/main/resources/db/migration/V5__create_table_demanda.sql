create table demanda (
        id bigint not null auto_increment,
        data_criacao datetime(6),
        data_entrega datetime(6),
        descricao text,
        titulo varchar(100),
        primary key (id)
)