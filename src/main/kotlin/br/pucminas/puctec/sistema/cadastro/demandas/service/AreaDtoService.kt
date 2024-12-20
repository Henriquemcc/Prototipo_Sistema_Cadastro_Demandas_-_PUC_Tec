package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AreaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AreaViewMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarAreaFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovaAreaFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.model.Area
import br.pucminas.puctec.sistema.cadastro.demandas.repository.AreaRepository
import org.springframework.stereotype.Service

@Service
class AreaDtoService(
    private val areaService: AreaService,
    private val areaViewMapper: AreaViewMapper,
    private val novaAreaFormMapper: NovaAreaFormMapper,
    private val atualizarAreaFormMapper: AtualizarAreaFormMapper
) {
    fun listar(): List<AreaView> = areaService.listar().map { areaViewMapper.map(it) }

    fun buscarPorId(idArea: Long): AreaView = areaViewMapper.map(areaService.buscarPorId(idArea))

    fun cadastrar(area: NovaAreaForm): AreaView = areaViewMapper.map(areaService.cadastrar(novaAreaFormMapper.map(area)))

    fun atualizar(area: AtualizarAreaForm, idArea: Long): AreaView = areaViewMapper.map(areaService.atualizar(atualizarAreaFormMapper.map(area), idArea))

    fun deletar(idArea: Long) = areaService.deletar(idArea)
}