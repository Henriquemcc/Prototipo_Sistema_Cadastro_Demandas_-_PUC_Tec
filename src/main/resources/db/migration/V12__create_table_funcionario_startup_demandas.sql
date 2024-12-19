create table funcionario_startup_demandas (
    funcionario_startup_id bigint not null,
    demandas_id bigint not null,
    foreign key funcionario_startup_id references funcionario_startup(id),
    foreign key demandas_id references demanda(id)
);