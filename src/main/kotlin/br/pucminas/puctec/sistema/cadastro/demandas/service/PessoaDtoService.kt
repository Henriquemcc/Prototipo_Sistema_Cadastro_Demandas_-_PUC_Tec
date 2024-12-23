package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.PessoaView
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarPessoaFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovaPessoaFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.PessoaViewMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PessoaDtoService (
    private val pessoaService: PessoaService,
    private val pessoaViewMapper: PessoaViewMapper,
    private val novaPessoaFormMapper: NovaPessoaFormMapper,
    private val atualizarPessoaFormMapper: AtualizarPessoaFormMapper
) {

    fun listar(nome: String? = null, sobrenome: String? = null, pageable: Pageable): Page<PessoaView> = pessoaService.listar(nome, sobrenome, pageable).map { pessoaViewMapper.map(it) }

    fun buscarPorId(idPessoa: Long): PessoaView = pessoaViewMapper.map(pessoaService.buscarPorId(idPessoa))

    fun cadastrar(pessoa: NovaPessoaForm): PessoaView = pessoaViewMapper.map(pessoaService.cadastrar(novaPessoaFormMapper.map(pessoa)))

    fun atualizar(pessoa: AtualizarPessoaForm, idPessoa: Long): PessoaView = pessoaViewMapper.map(pessoaService.atualizar(atualizarPessoaFormMapper.map(pessoa), idPessoa))

    fun deletar(idPessoa: Long) = pessoaService.deletar(idPessoa)
}