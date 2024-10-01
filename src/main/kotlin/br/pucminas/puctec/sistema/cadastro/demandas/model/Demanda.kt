package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import java.time.LocalDateTime

@Entity
@EnableAutoConfiguration
data class Demanda (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val titulo: String,
    val descricao: String,

    @ManyToMany
    val alunos: List<Aluno>,

    @ManyToOne
    val startup: Startup,

    val dataCriacao: LocalDateTime,
    val dataEntrega: LocalDateTime
)