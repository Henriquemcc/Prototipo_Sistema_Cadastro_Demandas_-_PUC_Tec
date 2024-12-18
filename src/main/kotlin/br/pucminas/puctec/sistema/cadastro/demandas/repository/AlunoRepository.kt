package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import org.springframework.data.jpa.repository.JpaRepository

interface AlunoRepository: JpaRepository<Aluno, Long>