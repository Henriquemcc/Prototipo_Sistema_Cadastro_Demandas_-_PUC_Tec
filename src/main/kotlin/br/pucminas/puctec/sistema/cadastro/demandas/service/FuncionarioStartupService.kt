package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioStartup
import br.pucminas.puctec.sistema.cadastro.demandas.repository.FuncionarioStartupRepository
import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class FuncionarioStartupService(
    private val funcionarioStartupRepository: FuncionarioStartupRepository,
    private val notFoundMessage: String = "Funcionário de Startup não encontrado!"
) {

    fun listar(): List<FuncionarioStartup> = funcionarioStartupRepository.findAll()

    fun buscarPorId(idFuncionarioStartup: Long): FuncionarioStartup = funcionarioStartupRepository.findById(idFuncionarioStartup).orElseThrow{NotFoundException(notFoundMessage)}

    fun cadastrar(funcionarioStartup: FuncionarioStartup): FuncionarioStartup {
        funcionarioStartupRepository.save(funcionarioStartup)
        return funcionarioStartup
    }

    fun atualizar(funcionarioStartup: FuncionarioStartup, idFuncionarioStartup: Long): FuncionarioStartup {
        val funcionarioStartupAnterior = funcionarioStartupRepository.findById(idFuncionarioStartup).orElseThrow{NotFoundException(notFoundMessage)}

        return funcionarioStartupAnterior
    }

    fun deletar(idFuncionarioStartup: Long) = funcionarioStartupRepository.deleteById(idFuncionarioStartup)
}