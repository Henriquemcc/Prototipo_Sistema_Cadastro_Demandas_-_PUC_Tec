package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepository: JpaRepository<Pessoa, Long>
