package br.pucminas.puctec.sistema.cadastro.demandas.dto

data class AlunoView(
    val id: Long,
    val nome: String,
    val matricula: String,
    val cpf: String,
    val curso: String
)