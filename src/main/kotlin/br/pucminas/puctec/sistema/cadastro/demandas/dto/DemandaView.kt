package br.pucminas.puctec.sistema.cadastro.demandas.dto

import java.time.LocalDateTime

data class DemandaView(
    val id: Long,
    val titulo: String,
    val descricao: String,
    val idAlunos: List<Long>,
    val idStartup: Long,
    val dataCriacao: LocalDateTime,
    val dataEntrega: LocalDateTime
)