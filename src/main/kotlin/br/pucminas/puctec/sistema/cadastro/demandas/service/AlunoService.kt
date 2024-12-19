package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.repository.AlunoRepository
import org.springframework.stereotype.Service

@Service
class AlunoService(
    private val alunoRepository: AlunoRepository,
    private val notFoundMessage: String = "Aluno(a) não encontrado(a)!"
){
    fun listar(): List<Aluno> = alunoRepository.findAll()

    fun buscarPorId(idAluno: Long): Aluno = alunoRepository.findById(idAluno).orElseThrow{ NotFoundException(notFoundMessage) }

    fun cadastrar(aluno: Aluno): Aluno {
        alunoRepository.save(aluno)
        return aluno
    }

    fun atualizar(aluno: Aluno, idAluno: Long): Aluno {
        val alunoAnterior = alunoRepository.findById(idAluno).orElseThrow{NotFoundException(notFoundMessage)}
        alunoAnterior.pessoa = aluno.pessoa
        alunoAnterior.curso = aluno.curso
        alunoAnterior.matricula = aluno.matricula
        alunoAnterior.area = aluno.area
        alunoAnterior.professorOrientador = aluno.professorOrientador
        return alunoAnterior
    }

    fun deletar(idAluno: Long) = alunoRepository.deleteById(idAluno)
}