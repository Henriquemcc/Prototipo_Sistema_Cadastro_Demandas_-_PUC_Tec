package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.FuncionarioStartupView
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioStartup
import org.springframework.stereotype.Component

@Component
class FuncionarioStartupViewMapper: Mapper<FuncionarioStartup, FuncionarioStartupView> {
    override fun map(t: FuncionarioStartup): FuncionarioStartupView {
        return FuncionarioStartupView(
            id = t.id,
            pessoaId = t.pessoa.id,
            demandasId = t.demandas.mapNotNull { it.id },
            startupId = t.startup.id
        )
    }
}