package br.pucminas.puctec.sistema.cadastro.demandas.model

import java.time.LocalDateTime

data class Demanda (
    val id: Long,
    val titulo: String,
    val descricao: String,
    val alunos: List<Aluno>,
    val startup: Startup,
    val dataCriacao: LocalDateTime,
    val dataEntrega: LocalDateTime
)