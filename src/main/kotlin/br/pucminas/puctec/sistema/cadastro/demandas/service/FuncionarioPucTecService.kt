package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import br.pucminas.puctec.sistema.cadastro.demandas.repository.FuncionarioPucTecRepository
import org.springframework.stereotype.Service

@Service
class FuncionarioPucTecService(
    private val funcionarioPucTecRepository: FuncionarioPucTecRepository,
    private val notFoundMessage: String = "Funcionário PUC Tec não encontrado!"
) {

    fun listar(): List<FuncionarioPucTec> = funcionarioPucTecRepository.findAll()

    fun buscarPorId(idFuncionarioPucTec: Long): FuncionarioPucTec = funcionarioPucTecRepository.findById(idFuncionarioPucTec).orElseThrow{ NotFoundException(notFoundMessage) }

    fun cadastrar(funcionarioPucTec: FuncionarioPucTec): FuncionarioPucTec {
        funcionarioPucTecRepository.save(funcionarioPucTec)
        return funcionarioPucTec
    }

    fun atualizar(funcionarioPucTec: FuncionarioPucTec, idFuncionarioPucTec: Long): FuncionarioPucTec {
        val funcionarioPucTecAnterior = funcionarioPucTecRepository.findById(idFuncionarioPucTec).orElseThrow{NotFoundException(notFoundMessage)}
        funcionarioPucTecAnterior.pessoa = funcionarioPucTec.pessoa
        return funcionarioPucTecAnterior
    }

    fun deletar(idFuncionarioPucTec: Long) = funcionarioPucTecRepository.deleteById(idFuncionarioPucTec)
}