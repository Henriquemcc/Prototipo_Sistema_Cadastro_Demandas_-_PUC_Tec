package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.DemandaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.DemandaFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.DemandaViewMapper
import org.springframework.stereotype.Service

@Service
class DemandaViewService (
    private val demandaService: DemandaService,
    private val demandaViewMapper: DemandaViewMapper,
    private val demandaFormMapper: DemandaFormMapper
) {

    fun listar(): List<DemandaView> {
        return demandaService.listar().map { d -> demandaViewMapper.map(d) }
    }

    fun buscarPorId(id: Long): DemandaView {
        return demandaViewMapper.map(demandaService.buscarPorId(id))
    }

    fun cadastrar(form: NovaDemandaForm) {
        demandaService.cadastrar(demandaFormMapper.map(form))
    }

    fun atualizar(form: NovaDemandaForm, id: Long) {
        demandaService.atualizar(demandaFormMapper.map(form), id)
    }

    fun deletar(id: Long) {
        demandaService.deletar(id)
    }
}