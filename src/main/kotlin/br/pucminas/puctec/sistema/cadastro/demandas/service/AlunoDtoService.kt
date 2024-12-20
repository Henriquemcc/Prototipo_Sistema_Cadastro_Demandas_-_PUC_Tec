package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AlunoView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AlunoViewMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarAlunoFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovoAlunoFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.repository.AlunoRepository
import org.springframework.stereotype.Service

@Service
class AlunoDtoService(
    private val alunoService: AlunoService,
    private val alunoViewMapper: AlunoViewMapper,
    private val novoAlunoFormMapper: NovoAlunoFormMapper,
    private val atualizarAlunoFormMapper: AtualizarAlunoFormMapper
){
    fun listar(): List<AlunoView> = alunoService.listar().map { alunoViewMapper.map(it) }

    fun buscarPorId(idAluno: Long): AlunoView = alunoViewMapper.map(alunoService.buscarPorId(idAluno))

    fun cadastrar(aluno: NovoAlunoForm): AlunoView = alunoViewMapper.map(alunoService.cadastrar(novoAlunoFormMapper.map(aluno)))

    fun atualizar(aluno: AtualizarAlunoForm, idAluno: Long): AlunoView = alunoViewMapper.map(alunoService.atualizar(atualizarAlunoFormMapper.map(aluno), idAluno))

    fun deletar(idAluno: Long) = alunoService.deletar(idAluno)
}