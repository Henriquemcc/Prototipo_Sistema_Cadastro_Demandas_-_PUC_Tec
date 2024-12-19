package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.*

@Entity
data class FuncionarioStartup(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @OneToOne
    var pessoa: Pessoa,
    @ManyToOne
    var startup: Startup,
    @OneToMany
    val demandas: List<Demanda> = mutableListOf()
)