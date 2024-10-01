package br.pucminas.puctec.sistema.cadastro.demandas.dto

import java.time.LocalDateTime

data class NovaDemandaForm (
    val titulo: String,
    val descricao: String,
    val idAlunos: List<Long>,
    val idStartup: Long,
    val dataEntrega: LocalDateTime
)