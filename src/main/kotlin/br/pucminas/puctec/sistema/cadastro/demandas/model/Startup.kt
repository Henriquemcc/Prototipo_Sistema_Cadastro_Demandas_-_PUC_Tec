package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.EnableAutoConfiguration

@Entity
@EnableAutoConfiguration
data class Startup (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val razaoSocial: String,
    val cnpj: String,

    @Embedded
    val rodada: Rodada
)