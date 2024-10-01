package br.pucminas.puctec.sistema.cadastro.demandas.dto

import br.pucminas.puctec.sistema.cadastro.demandas.model.Rodada

data class NovaStartupForm (
    val razaoSocial: String,
    val cnpj: String,
    val rodada: Rodada
)