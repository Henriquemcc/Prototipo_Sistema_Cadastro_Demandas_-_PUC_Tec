package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.PessoaView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Pessoa
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleService
import org.springframework.stereotype.Component

@Component
class PessoaViewMapper(
    private val roleService: RoleService
): Mapper<Pessoa, PessoaView> {
    override fun map(t: Pessoa): PessoaView {
        return PessoaView(
            id = t.id,
            nome = t.nome,
            role = t.role.map { it.id },
            cpf = t.cpf,
            email = t.email,
            telefone = t.telefone,
            sobrenome = t.sobrenome
        )
    }
}