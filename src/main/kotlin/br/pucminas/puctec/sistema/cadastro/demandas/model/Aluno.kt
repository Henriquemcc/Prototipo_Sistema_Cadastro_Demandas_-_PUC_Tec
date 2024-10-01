package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.EnableAutoConfiguration

@Entity
@EnableAutoConfiguration
data class Aluno(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val nome: String,
    val matricula: String,
    val cpf: String,
    val curso: String
)