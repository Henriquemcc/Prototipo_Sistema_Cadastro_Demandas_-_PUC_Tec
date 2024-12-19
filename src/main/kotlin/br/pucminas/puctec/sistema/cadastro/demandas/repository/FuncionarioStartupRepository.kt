package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioStartup
import org.springframework.data.jpa.repository.JpaRepository

interface FuncionarioStartupRepository: JpaRepository<FuncionarioStartup, Long>