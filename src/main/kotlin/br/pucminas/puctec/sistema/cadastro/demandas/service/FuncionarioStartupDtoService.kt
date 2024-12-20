package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarFuncionarioStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.FuncionarioStartupView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoFuncionarioStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioStartup
import br.pucminas.puctec.sistema.cadastro.demandas.repository.FuncionarioStartupRepository
import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarFuncionarioStartupFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.FuncionarioStartupViewMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovoFuncionarioStartupFormMapper
import org.springframework.stereotype.Service

@Service
class FuncionarioStartupDtoService(
    private val funcionarioStartupService: FuncionarioStartupService,
    private val funcionarioStartupViewMapper: FuncionarioStartupViewMapper,
    private val novoFuncionarioStartupFormMapper: NovoFuncionarioStartupFormMapper,
    private val atualizarFuncionarioStartupFormMapper: AtualizarFuncionarioStartupFormMapper
) {

    fun listar(): List<FuncionarioStartupView> = funcionarioStartupService.listar().map { funcionarioStartupViewMapper.map(it) }

    fun buscarPorId(idFuncionarioStartup: Long): FuncionarioStartupView = funcionarioStartupViewMapper.map(funcionarioStartupService.buscarPorId(idFuncionarioStartup))

    fun cadastrar(funcionarioStartup: NovoFuncionarioStartupForm): FuncionarioStartupView = funcionarioStartupViewMapper.map(funcionarioStartupService.cadastrar(novoFuncionarioStartupFormMapper.map(funcionarioStartup)))

    fun atualizar(funcionarioStartup: AtualizarFuncionarioStartupForm, idFuncionarioStartup: Long): FuncionarioStartupView = funcionarioStartupViewMapper.map(funcionarioStartupService.atualizar(atualizarFuncionarioStartupFormMapper.map(funcionarioStartup), idFuncionarioStartup))

    fun deletar(idFuncionarioStartup: Long) = funcionarioStartupService.deletar(idFuncionarioStartup)
}