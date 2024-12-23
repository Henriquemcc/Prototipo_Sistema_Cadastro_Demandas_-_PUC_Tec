package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaPessoaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.PessoaView
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaDtoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.hibernate.query.SortDirection
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
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
    @Cacheable("pessoas")
    fun listar(@RequestParam(required = false) nome: String?, @RequestParam(required = false) sobrenome: String?, @PageableDefault(size = 128, sort = ["nome", "sobrenome"], direction = Sort.Direction.ASC) pageable: Pageable): Page<PessoaView> = pessoaDtoService.listar(nome, sobrenome, pageable)

    @GetMapping("/{idPessoa}")
    fun buscarPorId(@PathVariable idPessoa: Long): PessoaView = pessoaDtoService.buscarPorId(idPessoa)

    @PostMapping
    @Transactional
    @CacheEvict(value = ["pessoas"], allEntries = true)
    fun cadastrar(@RequestBody @Valid pessoa: NovaPessoaForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<PessoaView> {
        val pessoaCadastrada = pessoaDtoService.cadastrar(pessoa)
        val uri = uriComponentsBuilder.path("/pessoas/${pessoaCadastrada.id}").build().toUri()
        return ResponseEntity.created(uri).body(pessoaCadastrada)
    }

    @PutMapping("/{idPessoa}")
    @Transactional
    @CacheEvict(value = ["pessoas"], allEntries = true)
    fun atualizar(@RequestBody @Valid pessoa: AtualizarPessoaForm, @PathVariable idPessoa: Long): ResponseEntity<PessoaView> = ResponseEntity.ok(pessoaDtoService.atualizar(pessoa, idPessoa))

    @DeleteMapping("/{idPessoa}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["pessoas"], allEntries = true)
    fun deletar(@PathVariable idPessoa: Long) = pessoaDtoService.deletar(idPessoa)
}