package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.*
import jakarta.validation.constraints.Size

@Entity
data class Aluno(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Size(max=100)
    var curso: String,
    @Size(max=10)
    var matricula: String,
    @OneToOne
    var pessoa: Pessoa
)