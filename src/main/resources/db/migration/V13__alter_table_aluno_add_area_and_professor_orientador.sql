alter table aluno
    add column area_id bigint;
alter table aluno
    add constraint fk_area foreign key (area_id) references area (id);