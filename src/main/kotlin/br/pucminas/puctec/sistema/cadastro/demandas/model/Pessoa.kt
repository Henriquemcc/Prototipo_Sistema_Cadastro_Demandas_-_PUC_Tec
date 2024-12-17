package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CPF

@Entity
data class Pessoa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Size(max = 100)
    var nome: String,
    @Size(max = 100)
    var sobrenome: String,
    @Size(max = 15) @NotNull @NotEmpty
    var telefone: String,
    @Size(max = 254) @NotNull @NotEmpty
    var email: String,
    @CPF
    var cpf: String,
    var senha: String,
)