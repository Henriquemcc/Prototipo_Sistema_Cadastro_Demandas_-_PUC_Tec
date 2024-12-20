package br.pucminas.puctec.sistema.cadastro.demandas.dto


data class FuncionarioStartupView(
    val id: Long?,
    var pessoaId: Long?,
    var startupId: Long?,
    val demandasId: List<Long>
)