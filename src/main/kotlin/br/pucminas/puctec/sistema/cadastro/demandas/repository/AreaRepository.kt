package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.Area
import org.springframework.data.jpa.repository.JpaRepository

interface AreaRepository: JpaRepository<Area, Long>