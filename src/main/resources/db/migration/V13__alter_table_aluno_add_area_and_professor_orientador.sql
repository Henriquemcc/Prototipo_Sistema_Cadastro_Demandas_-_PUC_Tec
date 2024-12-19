alter table aluno
    add column area_id bigint,
    add column professor_orientador_id bigint,
    add constraint fk_area foreign key (area_id) references area (id),
    add constraint fk_professor_orientador foreign key (professor_orientador_id) references professor_orientador (id);