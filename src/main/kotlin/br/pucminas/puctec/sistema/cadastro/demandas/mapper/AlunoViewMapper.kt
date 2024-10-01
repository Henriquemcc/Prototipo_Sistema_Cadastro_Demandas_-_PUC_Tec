package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AlunoView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import org.springframework.stereotype.Component

@Component
class AlunoViewMapper: Mapper<Aluno, AlunoView> {
    override fun map(aluno: Aluno): AlunoView {
        return AlunoView(aluno.id, aluno.nome, aluno.matricula, aluno.cpf, aluno.curso)
    }
}