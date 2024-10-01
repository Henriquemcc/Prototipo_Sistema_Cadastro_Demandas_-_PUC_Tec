package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import org.springframework.stereotype.Component

@Component
class StartupFormMapper: Mapper<NovaStartupForm, Startup> {
    override fun map(form: NovaStartupForm): Startup {
        return Startup(Long.MIN_VALUE, form.razaoSocial, form.cnpj, form.rodada)
    }
}