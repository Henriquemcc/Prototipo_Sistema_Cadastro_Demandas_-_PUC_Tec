create table aluno_demanda (
    aluno_id bigint not null,
    demanda_id bigint not null,
    foreign key aluno_id references aluno(id),
    foreign key demanda_id references demanda(id)
);