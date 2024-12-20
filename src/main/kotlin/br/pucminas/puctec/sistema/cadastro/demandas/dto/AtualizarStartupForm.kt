package br.pucminas.puctec.sistema.cadastro.demandas.dto

import br.pucminas.puctec.sistema.cadastro.demandas.model.Rodada
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CNPJ


data class AtualizarStartupForm(
    @field:CNPJ
    var cnpj: String,
    @field:Size(max = 100) @field:NotNull @field:NotEmpty
    var nome: String,
    var rodada: Rodada,
)