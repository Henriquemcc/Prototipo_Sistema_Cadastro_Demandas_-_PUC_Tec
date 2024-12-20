package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import br.pucminas.puctec.sistema.cadastro.demandas.repository.DemandaRepository
import org.springframework.stereotype.Service

@Service
class DemandaService(
    private val demandaRepository: DemandaRepository,
    private val notFoundMessage: String = "Demanda não encontrada!"
) {
    fun listar(): List<Demanda> = demandaRepository.findAll()

    fun buscarPorId(idDemanda: Long): Demanda = demandaRepository.findById(idDemanda).orElseThrow{ NotFoundException(notFoundMessage) }

    fun cadastrar(demanda: Demanda): Demanda {
        demandaRepository.save(demanda)
        return demanda
    }

    fun atualizar(demanda: Demanda, idDemanda: Long): Demanda {
        val demandaAnterior = demandaRepository.findById(idDemanda).orElseThrow{NotFoundException(notFoundMessage)}
        demandaAnterior.titulo = demanda.titulo
        demandaAnterior.descricao = demanda.descricao
        demandaAnterior.dataCriacao = demanda.dataCriacao
        demandaAnterior.dataEntrega = demanda.dataEntrega
        demandaAnterior.subdemandas = demanda.subdemandas
        demandaAnterior.alunoResponsavel = demanda.alunoResponsavel
        return demandaAnterior
    }

    fun deletar(idDemanda: Long) = demandaRepository.deleteById(idDemanda)
}