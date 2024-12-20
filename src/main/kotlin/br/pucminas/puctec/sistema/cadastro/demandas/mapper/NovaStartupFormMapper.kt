package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import org.springframework.stereotype.Component

@Component
class NovaStartupFormMapper: Mapper<NovaStartupForm, Startup> {
    override fun map(t: NovaStartupForm): Startup {
        return Startup(
            nome = t.nome,
            cnpj = t.cnpj,
            rodada = t.rodada
        )
    }
}