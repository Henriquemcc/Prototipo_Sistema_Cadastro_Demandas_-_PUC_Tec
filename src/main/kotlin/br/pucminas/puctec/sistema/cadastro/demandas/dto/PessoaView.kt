package br.pucminas.puctec.sistema.cadastro.demandas.dto

data class PessoaView(
    val id: Long?,
    val nome: String,
    val sobrenome: String,
    val telefone: String,
    var email: String,
    var cpf: String,
    val role: List<Long>
)
