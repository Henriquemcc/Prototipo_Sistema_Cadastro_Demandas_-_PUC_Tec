package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.Size

@Entity
data class Aluno(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Size(max=100)
    val curso: String,
    @Size(max=10)
    val matricula: String,
    @OneToOne
    val pessoa: Pessoa
)