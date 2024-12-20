package br.pucminas.puctec.sistema.cadastro.demandas.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CPF

data class NovaPessoaForm(
    @field:Size(max = 100) @field:NotNull @field:NotEmpty
    var nome: String,
    @field:Size(max = 100) @field:NotNull @field:NotEmpty
    var sobrenome: String,
    @field:Size(max = 15) @field:NotNull @field:NotEmpty
    var telefone: String,
    @field:Size(max = 254) @field:NotNull @field:NotEmpty
    var email: String,
    @field:CPF
    var cpf: String,
    @field:NotNull @field:NotEmpty
    var senha: String,
    val role: List<Long> = mutableListOf()
)