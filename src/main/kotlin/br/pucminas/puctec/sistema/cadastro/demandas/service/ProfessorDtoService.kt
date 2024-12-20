package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarProfessorForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoProfessorForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.ProfessorView
import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarProfessorFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovoProfessorFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.ProfessorViewMapper
import br.pucminas.puctec.sistema.cadastro.demandas.model.Professor
import br.pucminas.puctec.sistema.cadastro.demandas.repository.ProfessorRepository
import org.springframework.stereotype.Service

@Service
class ProfessorDtoService(
    private val professorService: ProfessorService,
    private val professorViewMapper: ProfessorViewMapper,
    private val novoProfessorFormMapper: NovoProfessorFormMapper,
    private val atualizarProfessorFormMapper: AtualizarProfessorFormMapper
) {

    fun listar(): List<ProfessorView> = professorService.listar().map { professorViewMapper.map(it) }

    fun buscarPorId(idProfessor: Long): ProfessorView = professorViewMapper.map(professorService.buscarPorId(idProfessor))

    fun cadastrar(professor: NovoProfessorForm): ProfessorView = professorViewMapper.map(professorService.cadastrar(novoProfessorFormMapper.map(professor)))

    fun atualizar(professor: AtualizarProfessorForm, idProfessor: Long): ProfessorView = professorViewMapper.map(professorService.atualizar(atualizarProfessorFormMapper.map(professor), idProfessor))

    fun deletar(idProfessor: Long) = professorService.deletar(idProfessor)
}