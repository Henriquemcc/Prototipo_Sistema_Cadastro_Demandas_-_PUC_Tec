package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Pessoa
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleService
import org.springframework.stereotype.Component

@Component
class AtualizarPessoaFormMapper(
    private val roleService: RoleService
): Mapper<AtualizarPessoaForm, Pessoa> {
    override fun map(t: AtualizarPessoaForm): Pessoa {
        return Pessoa(
            nome = t.nome,
            sobrenome = t.sobrenome,
            roles = t.rolesId.map {
                roleService.buscarPorId(it)
            },
            cpf = t.cpf,
            email = t.email,
            senha = t.senha,
            telefone = t.telefone
        )
    }
}