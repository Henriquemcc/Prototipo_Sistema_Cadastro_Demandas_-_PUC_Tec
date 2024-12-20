package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Area
import org.springframework.stereotype.Component

@Component
class AtualizarAreaFormMapper: Mapper<AtualizarAreaForm, Area> {
    override fun map(t: AtualizarAreaForm): Area {
        return Area(
            nome = t.nome
        )
    }
}