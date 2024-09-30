package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import org.springframework.stereotype.Service

@Service
class DemandaService (private val demandas: MutableList<Demanda> = mutableListOf()) {

    fun listar(): List<Demanda> {
        return demandas
    }

    fun buscarPorId(id: Long): Demanda {
        return demandas.first {
            d -> d.id == id
        }
    }

    fun cadastrar(demanda: Demanda) {
        demandas.add(demanda)
    }

    fun atualizar(demanda: Demanda, id: Long) {
        val demandaRemovida = demandas.first { d -> d.id == id }
        demandas.remove(demandaRemovida)
        demandas.add(demanda)
    }

    fun deletar(id: Long) {
        val demandaRemovida = demandas.first { d -> d.id == id }
        demandas.remove(demandaRemovida)
    }

}