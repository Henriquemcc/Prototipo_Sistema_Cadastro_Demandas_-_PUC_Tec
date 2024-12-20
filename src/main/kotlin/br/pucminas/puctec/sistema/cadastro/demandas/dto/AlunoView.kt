package br.pucminas.puctec.sistema.cadastro.demandas.dto

data class AlunoView(
    val id: Long?,
    var curso: String,
    var matricula: String,
    var pessoaId: Long?,
    var areaId: Long?,
    var professorOrientadorId: Long?,
    var demandasId: List<Long>
)