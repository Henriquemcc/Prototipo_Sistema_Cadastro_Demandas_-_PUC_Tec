package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@Entity
data class Demanda(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Size(max = 100)
    var titulo: String,
    var descricao: String,
    var dataEntrega: LocalDateTime,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
    @OneToMany
    var subdemandas: List<Demanda> = mutableListOf()
)