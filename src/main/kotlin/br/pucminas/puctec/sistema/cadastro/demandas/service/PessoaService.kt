package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.model.Pessoa
import br.pucminas.puctec.sistema.cadastro.demandas.repository.PessoaRepository
import org.springframework.stereotype.Service

@Service
class PessoaService (
    private val pessoaRepository: PessoaRepository,
    private val notFoundMessage: String = "Pessoa não encontrada!"
) {

    fun listar(): List<Pessoa> = pessoaRepository.findAll()

    fun buscarPorId(idPessoa: Long): Pessoa = pessoaRepository.findById(idPessoa).orElseThrow{NotFoundException(notFoundMessage)}

    fun cadastrar(pessoa: Pessoa): Pessoa {
        pessoaRepository.save(pessoa)
        return pessoa
    }

    fun atualizar(pessoa: Pessoa, idPessoa: Long): Pessoa {
        val pessoaAnterior = pessoaRepository.findById(idPessoa).orElseThrow{NotFoundException(notFoundMessage)}
        pessoaAnterior.nome = pessoa.nome
        pessoaAnterior.sobrenome = pessoa.sobrenome
        pessoaAnterior.telefone = pessoa.telefone
        pessoaAnterior.email = pessoa.email
        pessoaAnterior.cpf = pessoa.cpf
        pessoaAnterior.senha = pessoa.senha
        return pessoaAnterior
    }

    fun deletar(idPessoa: Long) = pessoaRepository.deleteById(idPessoa)
}