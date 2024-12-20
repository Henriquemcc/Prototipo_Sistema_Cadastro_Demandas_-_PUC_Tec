package br.pucminas.puctec.sistema.cadastro.demandas.dto

import jakarta.validation.constraints.Size

data class AtualizarAlunoForm(
    @field:Size(max=100)
    var curso: String,
    @field:Size(max=10)
    var matricula: String,
    var pessoaId: Long,
    var areaId: Long,
    var professorOrientadorId: Long,
    var demandasId: List<Long>
)