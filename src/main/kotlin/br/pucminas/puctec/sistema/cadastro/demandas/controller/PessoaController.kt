package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.PessoaView
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaDtoService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoas")
class PessoaController(
    private val pessoaDtoService: PessoaDtoService
) {

    @GetMapping
    fun listar(): List<PessoaView> = pessoaDtoService.listar()

    @GetMapping("/{idPessoa}")
    fun buscarPorId(@PathVariable idPessoa: Long): PessoaView = pessoaDtoService.buscarPorId(idPessoa)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody pessoa: NovaPessoaForm): PessoaView = pessoaDtoService.cadastrar(pessoa)

    @PutMapping("/{idPessoa}")
    @Transactional
    fun atualizar(@RequestBody pessoa: AtualizarPessoaForm, @PathVariable idPessoa: Long): PessoaView = pessoaDtoService.atualizar(pessoa, idPessoa)

    @DeleteMapping("/{idPessoa}")
    @Transactional
    fun deletar(@PathVariable idPessoa: Long) = pessoaDtoService.deletar(idPessoa)
}