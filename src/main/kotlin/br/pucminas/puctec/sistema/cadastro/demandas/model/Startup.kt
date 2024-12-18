package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CNPJ

@Entity
data class Startup(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @CNPJ
    var cnpj: String,
    @Size(max = 100)
    var nome: String,
    @Embedded
    var rodada: Rodada,
)
