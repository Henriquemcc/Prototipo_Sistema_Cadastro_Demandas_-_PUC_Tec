package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Area
import org.springframework.stereotype.Component

@Component
class NovaAreaFormMapper: Mapper<NovaAreaForm, Area> {
    override fun map(t: NovaAreaForm): Area {
        return Area(
            nome = t.nome
        )
    }
}