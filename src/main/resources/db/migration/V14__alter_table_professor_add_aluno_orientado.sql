alter table professor
    add column aluno_orientado_id bigint,
    add constraint fk_aluno_orientado foreign key (aluno_orientado_id) references aluno(id);