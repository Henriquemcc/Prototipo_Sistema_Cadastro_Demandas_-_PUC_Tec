package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.*

@Entity
data class FuncionarioPucTec(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @OneToOne
    var pessoa: Pessoa
)