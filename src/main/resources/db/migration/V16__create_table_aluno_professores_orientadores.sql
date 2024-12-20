create table aluno_professores_orientadores (
    aluno_id bigint not null,
    professor_id bigint not null,
    foreign key (aluno_id) references aluno(id),
    foreign key (professor_id) references professor(id)
);