package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.Professor
import org.springframework.data.jpa.repository.JpaRepository

interface ProfessorRepository: JpaRepository<Professor, Long>