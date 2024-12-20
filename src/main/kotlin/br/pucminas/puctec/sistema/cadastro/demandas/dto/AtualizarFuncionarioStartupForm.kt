package br.pucminas.puctec.sistema.cadastro.demandas.dto


data class AtualizarFuncionarioStartupForm(
    var pessoaId: Long,
    var startupId: Long,
    val demandasId: List<Long>
)