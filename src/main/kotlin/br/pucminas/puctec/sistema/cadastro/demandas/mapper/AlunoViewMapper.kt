package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AlunoView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import org.springframework.stereotype.Component

@Component
class AlunoViewMapper: Mapper<Aluno, AlunoView> {
    override fun map(t: Aluno): AlunoView {
        return AlunoView(
            id = t.id,
            professoresOrientadoresId = t.professoresOrientadores.mapNotNull { it.id },
            curso = t.curso,
            areaId = t.area.id,
            pessoaId = t.pessoa.id,
            matricula = t.matricula,
            demandasId = t.demandas.mapNotNull { it.id }
        )
    }
}