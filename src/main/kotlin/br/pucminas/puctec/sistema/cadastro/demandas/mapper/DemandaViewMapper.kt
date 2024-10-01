package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.DemandaView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda

class DemandaViewMapper: Mapper<Demanda, DemandaView> {
    override fun map(demanda: Demanda): DemandaView {
        return DemandaView(demanda.id, demanda.titulo, demanda.descricao, demanda.alunos.map { a -> a.id }, demanda.startup.id, demanda.dataCriacao, demanda.dataEntrega)
    }
}