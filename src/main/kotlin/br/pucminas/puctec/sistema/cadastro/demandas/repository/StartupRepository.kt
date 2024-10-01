package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import org.springframework.data.jpa.repository.JpaRepository

interface StartupRepository: JpaRepository<Startup, Long> {

}