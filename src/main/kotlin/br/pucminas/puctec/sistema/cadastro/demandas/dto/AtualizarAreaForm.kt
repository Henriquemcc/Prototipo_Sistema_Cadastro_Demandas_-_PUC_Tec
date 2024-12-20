package br.pucminas.puctec.sistema.cadastro.demandas.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AtualizarAreaForm(
    @field:NotNull @field:NotEmpty @field:Size(max=100)
    var nome: String,
)
