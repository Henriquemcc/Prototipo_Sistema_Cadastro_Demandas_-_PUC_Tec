package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.ProfessorView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Professor
import org.springframework.stereotype.Component

@Component
class ProfessorViewMapper: Mapper<Professor, ProfessorView> {
    override fun map(t: Professor): ProfessorView {
        return ProfessorView(
            id = t.id,
            areaId = t.area.id,
            pessoaId = t.pessoa.id,
            alunoOrientadoId = t.alunoOrientado.id
        )
    }
}