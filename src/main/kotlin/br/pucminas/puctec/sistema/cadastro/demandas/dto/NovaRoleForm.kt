package br.pucminas.puctec.sistema.cadastro.demandas.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


data class NovaRoleForm(
    @field:Size(max= 50) @field:NotNull @field:NotEmpty
    var nome: String,
)