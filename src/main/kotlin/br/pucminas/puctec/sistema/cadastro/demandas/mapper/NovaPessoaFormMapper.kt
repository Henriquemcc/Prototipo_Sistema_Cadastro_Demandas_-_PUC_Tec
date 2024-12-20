package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Pessoa
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleService
import org.springframework.stereotype.Component

@Component
class NovaPessoaFormMapper(
    private val roleService: RoleService
): Mapper<NovaPessoaForm, Pessoa> {
    override fun map(t: NovaPessoaForm): Pessoa {
        return Pessoa(
            nome = t.nome,
            sobrenome = t.sobrenome,
            role = t.role.map {
                roleService.buscarPorId(it)
            },
            cpf = t.cpf,
            email = t.email,
            senha = t.senha,
            telefone = t.telefone
        )
    }
}