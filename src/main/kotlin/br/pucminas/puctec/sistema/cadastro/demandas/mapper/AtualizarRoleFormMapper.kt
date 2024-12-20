package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import org.springframework.stereotype.Component

@Component
class AtualizarRoleFormMapper: Mapper<AtualizarRoleForm, Role> {
    override fun map(t: AtualizarRoleForm): Role {
        return Role(
            nome = t.nome
        )
    }
}