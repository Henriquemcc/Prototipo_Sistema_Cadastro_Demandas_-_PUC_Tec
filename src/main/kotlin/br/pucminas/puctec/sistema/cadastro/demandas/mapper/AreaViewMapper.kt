package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AreaView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Area
import org.springframework.stereotype.Component

@Component
class AreaViewMapper: Mapper<Area, AreaView> {
    override fun map(t: Area): AreaView {
        return AreaView(
            id = t.id,
            nome = t.nome
        )
    }
}