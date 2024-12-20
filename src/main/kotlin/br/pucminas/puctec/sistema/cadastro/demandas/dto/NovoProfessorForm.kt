package br.pucminas.puctec.sistema.cadastro.demandas.dto


data class NovoProfessorForm(
    var areaId: Long,
    var pessoaId: Long,
    var alunosOrientadosId: List<Long>
)