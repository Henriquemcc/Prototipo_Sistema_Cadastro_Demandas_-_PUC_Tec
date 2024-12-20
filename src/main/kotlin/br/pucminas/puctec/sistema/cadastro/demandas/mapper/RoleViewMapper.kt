package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.RoleView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import org.springframework.stereotype.Component

@Component
class RoleViewMapper: Mapper<Role, RoleView> {
    override fun map(t: Role): RoleView {
        return RoleView(
            id = t.id,
            nome = t.nome
        )
    }
}