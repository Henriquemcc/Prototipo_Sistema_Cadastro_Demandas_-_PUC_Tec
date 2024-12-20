create table demanda_funcionarios_startup(
    demanda_id bigint not null,
    funcionarios_startup_id bigint not null,
    foreign key (demanda_id) references demanda(id),
    foreign key (funcionarios_startup_id) references funcionario_startup(id)
);