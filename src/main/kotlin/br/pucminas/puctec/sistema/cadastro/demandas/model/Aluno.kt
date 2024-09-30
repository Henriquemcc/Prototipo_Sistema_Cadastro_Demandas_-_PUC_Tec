package br.pucminas.puctec.sistema.cadastro.demandas.model

data class Aluno(
    val id: Long,
    val nome: String,
    val matricula: String,
    val cpf: String,
    val curso: String
)