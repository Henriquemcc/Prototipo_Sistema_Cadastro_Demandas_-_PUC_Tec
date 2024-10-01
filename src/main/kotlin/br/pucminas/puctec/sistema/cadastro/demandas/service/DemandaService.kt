package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import br.pucminas.puctec.sistema.cadastro.demandas.repository.DemandaRepository
import org.springframework.stereotype.Service

@Service
class DemandaService (private val repository: DemandaRepository) {

    fun listar(): List<Demanda> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Demanda {
        return repository.getReferenceById(id)
    }

    fun cadastrar(demanda: Demanda) {
        repository.save(demanda)
    }

    fun atualizar(demanda: Demanda, id: Long) {
        val demandaRemovida = repository.getReferenceById(id)
        repository.delete(demandaRemovida)
        repository.save(demanda)
    }

    fun deletar(id: Long) {
        val demandaRemovida = repository.getReferenceById(id)
        repository.delete(demandaRemovida)
    }

}