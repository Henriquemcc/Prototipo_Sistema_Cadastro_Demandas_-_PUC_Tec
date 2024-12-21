package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.PessoaView
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaDtoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

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
    fun cadastrar(@RequestBody @Valid pessoa: NovaPessoaForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<PessoaView> {
        val pessoaCadastrada = pessoaDtoService.cadastrar(pessoa)
        val uri = uriComponentsBuilder.path("/pessoas/${pessoaCadastrada.id}").build().toUri()
        return ResponseEntity.created(uri).body(pessoaCadastrada)
    }

    @PutMapping("/{idPessoa}")
    @Transactional
    fun atualizar(@RequestBody @Valid pessoa: AtualizarPessoaForm, @PathVariable idPessoa: Long): ResponseEntity<PessoaView> = ResponseEntity.ok(pessoaDtoService.atualizar(pessoa, idPessoa))

    @DeleteMapping("/{idPessoa}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idPessoa: Long) = pessoaDtoService.deletar(idPessoa)
}