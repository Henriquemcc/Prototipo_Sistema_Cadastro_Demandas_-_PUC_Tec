package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.StartupView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import org.springframework.stereotype.Component

@Component
class StartupViewMapper: Mapper<Startup, StartupView> {
    override fun map(t: Startup): StartupView {
        return StartupView(
            id = t.id,
            nome = t.nome,
            cnpj = t.cnpj,
            rodada = t.rodada
        )
    }
}