package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import br.pucminas.puctec.sistema.cadastro.demandas.repository.StartupRepository
import org.springframework.stereotype.Service

@Service
class StartupService(
    private val startupRepository: StartupRepository,
    private val notFoundMessage: String = "Startup não encontrada!"
) {
    fun listar(): List<Startup> = startupRepository.findAll()

    fun buscarPorId(idStartup: Long): Startup = startupRepository.findById(idStartup).orElseThrow{NotFoundException(notFoundMessage)}

    fun cadastrar(startup: Startup): Startup {
        startupRepository.save(startup)
        return startup
    }

    fun atualizar(startup: Startup, idStartup: Long): Startup {
        val startupAnterior = startupRepository.findById(idStartup).orElseThrow{NotFoundException(notFoundMessage)}
        startupAnterior.nome = startup.nome
        startupAnterior.cnpj = startup.cnpj
        startupAnterior.rodada = startup.rodada
        return startupAnterior
    }

    fun deletar(idStartup: Long) = startupRepository.deleteById(idStartup)
}