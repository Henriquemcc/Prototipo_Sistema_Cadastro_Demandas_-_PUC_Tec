package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import org.springframework.data.jpa.repository.JpaRepository

interface FuncionarioPucTecRepository: JpaRepository<FuncionarioPucTec, Long>