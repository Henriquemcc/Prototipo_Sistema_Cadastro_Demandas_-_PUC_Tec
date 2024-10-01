package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.StartupView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup

class StartupsViewMapper: Mapper<Startup, StartupView> {
    override fun map(startup: Startup): StartupView {
        return StartupView(startup.id, startup.razaoSocial, startup.cnpj, startup.rodada)
    }
}