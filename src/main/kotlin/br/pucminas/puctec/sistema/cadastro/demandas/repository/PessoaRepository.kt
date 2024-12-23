package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.Pessoa
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepository: JpaRepository<Pessoa, Long> {
    fun findByNome(nome: String, pageable: Pageable): Page<Pessoa>
    fun findBySobrenome(sobrenome: String, pageable: Pageable): Page<Pessoa>
    fun findByNomeAndSobrenome(nome: String, sobrenome: String, pageable: Pageable): Page<Pessoa>
}
