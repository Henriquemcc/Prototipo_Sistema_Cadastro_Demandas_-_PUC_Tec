package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.model.Area
import br.pucminas.puctec.sistema.cadastro.demandas.repository.AreaRepository
import org.springframework.stereotype.Service

@Service
class AreaService(
    private val areaRepository: AreaRepository,
    private val notFoundMessage: String = "Área não encontrada!"
) {
    fun listar(): List<Area> = areaRepository.findAll()

    fun buscarPorId(idArea: Long): Area = areaRepository.findById(idArea).orElseThrow{ NotFoundException(notFoundMessage) }

    fun cadastrar(area: Area): Area {
        areaRepository.save(area)
        return area
    }

    fun atualizar(area: Area, idArea: Long): Area {
        val areaAnterior = areaRepository.findById(idArea).orElseThrow{NotFoundException(notFoundMessage)}
        areaAnterior.nome = area.nome
        return areaAnterior
    }

    fun deletar(idArea: Long) = areaRepository.deleteById(idArea)
}