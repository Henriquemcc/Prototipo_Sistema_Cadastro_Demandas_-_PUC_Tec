package br.pucminas.puctec.sistema.cadastro.demandas.model

data class Startup (
    val id: Long,
    val razaoSocial: String,
    val cnpj: String,
    val rodada: Rodada
)