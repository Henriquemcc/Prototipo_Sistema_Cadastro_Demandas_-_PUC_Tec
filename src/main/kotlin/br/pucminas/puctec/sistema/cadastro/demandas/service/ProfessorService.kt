package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.model.Professor
import br.pucminas.puctec.sistema.cadastro.demandas.repository.ProfessorRepository
import org.springframework.stereotype.Service

@Service
class ProfessorService(
    private val professorRepository: ProfessorRepository,
    private val notFoundMessage: String = "Professor(a) não encontrado(a)!"
) {

    fun listar(): List<Professor> = professorRepository.findAll()

    fun buscarPorId(idProfessor: Long): Professor = professorRepository.findById(idProfessor).orElseThrow{ NotFoundException(notFoundMessage) }

    fun cadastrar(professor: Professor): Professor {
        professorRepository.save(professor)
        return professor
    }

    fun atualizar(professor: Professor, idProfessor: Long): Professor {
        val professorAnterior = professorRepository.findById(idProfessor).orElseThrow{NotFoundException(notFoundMessage)}
        professorAnterior.pessoa = professor.pessoa
        professorAnterior.area = professor.area
        professorAnterior.alunoOrientado = professor.alunoOrientado
        return professorAnterior
    }

    fun deletar(idProfessor: Long) = professorRepository.deleteById(idProfessor)
}