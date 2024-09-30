package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import org.springframework.stereotype.Service

@Service
class StartupService(
    private val startups: MutableList<Startup> = mutableListOf()
) {

    fun listar(): List<Startup> {
        return startups
    }

    fun buscarPorId(id: Long): Startup {
        return startups.first { s -> s.id == id }
    }

    fun cadastrar(startup: Startup) {
        startups.add(startup)
    }

    fun atualizar(startup: Startup, id: Long) {
        val startupRemovida = startups.first { s -> s.id == id }
        startups.remove(startupRemovida)
        startups.add(startup)
    }

    fun deletar(id: Long) {
        val startupRemovida = startups.first { s -> s.id == id }
        startups.remove(startupRemovida)
    }
}
