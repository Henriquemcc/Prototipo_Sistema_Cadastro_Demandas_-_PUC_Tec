package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import org.springframework.stereotype.Component

@Component
class AtualizarStartupFormMapper: Mapper<AtualizarStartupForm, Startup> {
    override fun map(t: AtualizarStartupForm): Startup {
        return Startup(
            nome = t.nome,
            cnpj = t.cnpj,
            rodada = t.rodada
        )
    }
}