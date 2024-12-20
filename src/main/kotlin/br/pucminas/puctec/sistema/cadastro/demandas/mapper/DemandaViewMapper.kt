package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.DemandaView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import org.springframework.stereotype.Component

@Component
class DemandaViewMapper(
    private val alunoService: AlunoService
): Mapper<Demanda, DemandaView> {
    override fun map(t: Demanda): DemandaView {
        return DemandaView(
            id = t.id,
            titulo = t.titulo,
            alunosResponsaveisId = t.alunosResponsaveis.mapNotNull { it.id },
            descricao = t.descricao,
            subdemandasId = t.subdemandas.mapNotNull { it.id },
            dataCriacao = t.dataCriacao,
            dataEntrega = t.dataEntrega
        )
    }
}