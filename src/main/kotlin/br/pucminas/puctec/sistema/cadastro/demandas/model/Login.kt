package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

@Entity
data class Login (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @OneToOne
    val pessoa: Pessoa,

    @NotNull @NotEmpty
    val senha: String,
)