create table demanda_subdemandas (
    demanda_id bigint not null,
    subdemandas_id bigint not null,
    foreign key(demanda_id) references demanda(id),
    foreign key(subdemandas_id) references demanda(id)
)