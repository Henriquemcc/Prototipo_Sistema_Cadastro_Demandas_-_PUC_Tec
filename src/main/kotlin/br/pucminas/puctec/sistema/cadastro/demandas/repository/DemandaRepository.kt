package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import org.springframework.data.jpa.repository.JpaRepository

interface DemandaRepository: JpaRepository<Demanda, Long>