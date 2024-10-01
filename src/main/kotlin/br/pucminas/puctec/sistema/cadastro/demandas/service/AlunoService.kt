package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.repository.AlunoRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class AlunoService(private val alunosRepository: AlunoRepository) {

    fun listar(): List<Aluno> {
        return alunosRepository.findAll()
    }

    fun buscarPorId(id: Long): Aluno {
        return alunosRepository.getReferenceById(id)
    }

    fun cadastrar(aluno: Aluno) {
        alunosRepository.save(aluno)
    }

    fun atualizar(aluno: Aluno, id: Long) {
        val alunoRemovido = alunosRepository.getReferenceById(id)
        alunosRepository.delete(alunoRemovido)
        alunosRepository.save(aluno)
    }

    fun deletar(id: Long) {
        val alunoRemovido = alunosRepository.getReferenceById(id)
        alunosRepository.delete(alunoRemovido)
    }
}