package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.DemandaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarDemandaFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.DemandaViewMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovaDemandaFormMapper
import org.springframework.stereotype.Service

@Service
class DemandaDtoService(
    private val demandaService: DemandaService,
    private val demandaViewMapper: DemandaViewMapper,
    private val novaDemandaFormMapper: NovaDemandaFormMapper,
    private val atualizarDemandaFormMapper: AtualizarDemandaFormMapper
) {
    fun listar(): List<DemandaView> = demandaService.listar().map { demandaViewMapper.map(it) }

    fun buscarPorId(idDemanda: Long): DemandaView = demandaViewMapper.map(demandaService.buscarPorId(idDemanda))

    fun cadastrar(demanda: NovaDemandaForm): DemandaView = demandaViewMapper.map(demandaService.cadastrar(novaDemandaFormMapper.map(demanda)))

    fun atualizar(demanda: AtualizarDemandaForm, idDemanda: Long): DemandaView = demandaViewMapper.map(demandaService.atualizar(atualizarDemandaFormMapper.map(demanda), idDemanda))

    fun deletar(idDemanda: Long) = demandaService.deletar(idDemanda)
}