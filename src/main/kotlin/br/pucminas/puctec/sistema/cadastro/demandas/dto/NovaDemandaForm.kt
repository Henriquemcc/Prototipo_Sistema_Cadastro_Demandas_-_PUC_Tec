package br.pucminas.puctec.sistema.cadastro.demandas.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class NovaDemandaForm(
    @field:Size(max = 100) @field:NotNull @field:NotEmpty
    var titulo: String,
    var descricao: String,
    var dataEntrega: LocalDateTime,
    var subdemandasId: List<Long>,
    var alunosResponsaveisId: List<Long>
)