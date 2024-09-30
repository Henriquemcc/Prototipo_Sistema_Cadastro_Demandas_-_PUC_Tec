package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import org.springframework.stereotype.Service

@Service
class AlunoService(private val alunos: MutableList<Aluno> = mutableListOf()) {

    fun listar(): List<Aluno> {
        return alunos
    }

    fun buscarPorId(id: Long): Aluno {
        return alunos.first {
            a -> a.id == id
        }
    }

    fun cadastrar(aluno: Aluno) {
        alunos.add(aluno)
    }

    fun atualizar(aluno: Aluno, id: Long) {
        val alunoRemovido = alunos.first { a -> a.id == id }
        alunos.remove(alunoRemovido)
        alunos.add(aluno)
    }

    fun deletar(id: Long) {
        val alunoRemovido = alunos.first { a -> a.id == id }
        alunos.remove(alunoRemovido)
    }
}