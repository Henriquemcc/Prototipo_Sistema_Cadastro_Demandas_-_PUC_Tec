package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno

class AlunoFormMapper: Mapper<NovoAlunoForm, Aluno> {

    override fun map(form: NovoAlunoForm): Aluno {
        return Aluno(Long.MIN_VALUE, form.nome, form.matricula, form.cpf, form.curso)
    }
}