package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Pessoa
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoas")
class PessoaController(
    private val pessoaService: PessoaService
) {

    @GetMapping
    fun listar(): List<Pessoa> = pessoaService.listar()

    @GetMapping("/{idPessoa}")
    fun buscarPorId(@PathVariable idPessoa: Long): Pessoa = pessoaService.buscarPorId(idPessoa)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody pessoa: Pessoa): Pessoa = pessoaService.cadastrar(pessoa)

    @PutMapping("/{idPessoa}")
    @Transactional
    fun atualizar(@RequestBody pessoa: Pessoa, @PathVariable idPessoa: Long): Pessoa = pessoaService.atualizar(pessoa, idPessoa)

    @DeleteMapping("/{idPessoa}")
    @Transactional
    fun deletar(@PathVariable idPessoa: Long) = pessoaService.deletar(idPessoa)
}