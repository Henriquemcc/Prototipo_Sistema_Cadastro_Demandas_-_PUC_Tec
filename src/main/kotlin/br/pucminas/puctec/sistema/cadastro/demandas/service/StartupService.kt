package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import br.pucminas.puctec.sistema.cadastro.demandas.repository.StartupRepository
import org.springframework.stereotype.Service

@Service
class StartupService(
    private val repository: StartupRepository
) {

    fun listar(): List<Startup> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Startup {
        return repository.getReferenceById(id)
    }

    fun cadastrar(startup: Startup) {
        repository.save(startup)
    }

    fun atualizar(startup: Startup, id: Long) {
        val startupRemovida = repository.getReferenceById(id)
        repository.delete(startupRemovida)
        repository.save(startup)
    }

    fun deletar(id: Long) {
        val startupRemovida = repository.getReferenceById(id)
        repository.delete(startupRemovida)
    }
}
