package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CNPJ

@Entity
data class Startup(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @CNPJ
    var cnpj: String,
    @Size(max = 100)
    var nome: String,
    @Embedded
    var rodada: Rodada,
)
