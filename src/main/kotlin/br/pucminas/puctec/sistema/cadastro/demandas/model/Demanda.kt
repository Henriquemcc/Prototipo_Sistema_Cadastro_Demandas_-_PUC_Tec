package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@Entity
data class Demanda(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Size(max = 100)
    var titulo: String,
    var descricao: String,
    var dataEntrega: LocalDateTime,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
    @OneToMany
    var subdemandas: List<Demanda> = mutableListOf(),
    @ManyToMany(mappedBy = "demandas")
    var alunosResponsaveis: List<Aluno> = mutableListOf(),
    @ManyToMany(mappedBy = "demandas")
    var funcionariosStartupResponsaveis: List<FuncionarioStartup> = mutableListOf()
)