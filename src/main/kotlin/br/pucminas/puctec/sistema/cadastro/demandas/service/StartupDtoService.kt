package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.StartupView
import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarStartupFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovaStartupFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.StartupViewMapper
import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import br.pucminas.puctec.sistema.cadastro.demandas.repository.StartupRepository
import org.springframework.stereotype.Service

@Service
class StartupDtoService(
    private val startupService: StartupService,
    private val startupViewMapper: StartupViewMapper,
    private val novaStartupFormMapper: NovaStartupFormMapper,
    private val atualizarStartupFormMapper: AtualizarStartupFormMapper
) {
    fun listar(): List<StartupView> = startupService.listar().map { startupViewMapper.map(it) }

    fun buscarPorId(idStartup: Long): StartupView = startupViewMapper.map(startupService.buscarPorId(idStartup))

    fun cadastrar(startup: NovaStartupForm): StartupView = startupViewMapper.map(startupService.cadastrar(novaStartupFormMapper.map(startup)))

    fun atualizar(startup: AtualizarStartupForm, idStartup: Long): StartupView = startupViewMapper.map(startupService.atualizar(atualizarStartupFormMapper.map(startup), idStartup))

    fun deletar(idStartup: Long) = startupService.deletar(idStartup)
}