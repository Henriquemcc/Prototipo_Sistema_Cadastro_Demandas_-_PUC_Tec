package br.pucminas.puctec.sistema.cadastro.demandas.dto

import java.time.LocalDateTime

data class DemandaView(
    val id: Long?,
    var titulo: String,
    var descricao: String,
    var dataEntrega: LocalDateTime,
    var dataCriacao: LocalDateTime,
    var subdemandasId: List<Long>,
    var alunosResponsaveisId: List<Long>
)