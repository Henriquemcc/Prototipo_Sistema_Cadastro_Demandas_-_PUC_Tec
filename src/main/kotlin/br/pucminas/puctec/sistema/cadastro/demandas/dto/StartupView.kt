package br.pucminas.puctec.sistema.cadastro.demandas.dto

import br.pucminas.puctec.sistema.cadastro.demandas.model.Rodada

data class StartupView(
    val id: Long?,
    var cnpj: String,
    var nome: String,
    var rodada: Rodada,
)
