package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
data class PessoaRole(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToMany
    val pessoa: Pessoa,
    @ManyToMany
    val role: Role,
)
