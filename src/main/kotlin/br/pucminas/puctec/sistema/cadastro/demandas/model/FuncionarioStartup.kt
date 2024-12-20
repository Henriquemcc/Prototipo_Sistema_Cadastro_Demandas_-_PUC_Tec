package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.*

@Entity
data class FuncionarioStartup(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToOne
    var pessoa: Pessoa,
    @ManyToOne
    var startup: Startup,
    @ManyToMany
    @JoinTable(
        name = "demanda_funcionarios_startup",
        joinColumns = [JoinColumn(name = "funcionarios_startup_id")],
        inverseJoinColumns = [JoinColumn(name = "demanda_id")]
    )
    val demandas: List<Demanda> = mutableListOf()
)