package br.pucminas.puctec.sistema.cadastro.demandas.dto

data class AlunoView(
    val id: Long?,
    var curso: String,
    var matricula: String,
    var pessoaId: Long?,
    var areaId: Long?,
    var professoresOrientadoresId: List<Long>,
    var demandasId: List<Long>
)