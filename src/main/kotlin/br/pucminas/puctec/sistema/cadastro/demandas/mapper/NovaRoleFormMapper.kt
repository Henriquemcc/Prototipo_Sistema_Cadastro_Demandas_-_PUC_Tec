package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import org.springframework.stereotype.Component

@Component
class NovaRoleFormMapper: Mapper<NovaRoleForm, Role> {
    override fun map(t: NovaRoleForm): Role {
        return Role(
            nome = t.nome
        )
    }
}