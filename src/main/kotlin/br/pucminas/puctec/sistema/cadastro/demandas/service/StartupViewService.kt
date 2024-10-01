package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.StartupView
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.StartupFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.StartupsViewMapper

class StartupViewService (
    private val startupService: StartupService,
    private val startupsViewMapper: StartupsViewMapper,
    private val startupFormMapper: StartupFormMapper,
) {

    fun listar(): List<StartupView> {
        return startupService.listar().map { s -> startupsViewMapper.map(s) }
    }

    fun buscarPorId(id: Long): StartupView {
        return startupsViewMapper.map(startupService.buscarPorId(id))
    }

    fun cadastrar(form: NovaStartupForm) {
        startupService.cadastrar(startupFormMapper.map(form))
    }

    fun atualizar(form: NovaStartupForm, id: Long) {
        startupService.atualizar(startupFormMapper.map(form), id)
    }

    fun deletar(id: Long) {
        startupService.deletar(id)
    }
}