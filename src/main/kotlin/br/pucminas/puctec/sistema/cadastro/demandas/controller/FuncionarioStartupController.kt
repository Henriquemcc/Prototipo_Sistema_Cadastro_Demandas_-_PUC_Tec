package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarFuncionarioStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.FuncionarioStartupView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoFuncionarioStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioStartupDtoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/funcionariosStartup")
class FuncionarioStartupController(
    private val funcionarioStartupDtoService: FuncionarioStartupDtoService
) {

    @GetMapping
    @Cacheable("funcionarioStartup")
    fun listar(): List<FuncionarioStartupView> = funcionarioStartupDtoService.listar()

    @GetMapping("/{idFuncionarioStartup}")
    fun buscarPorId(@PathVariable idFuncionarioStartup: Long): FuncionarioStartupView = funcionarioStartupDtoService.buscarPorId(idFuncionarioStartup)

    @PostMapping
    @Transactional
    @CacheEvict(value = ["funcionarioStartup"], allEntries = true)
    fun cadastrar(@RequestBody @Valid funcionarioStartup: NovoFuncionarioStartupForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<FuncionarioStartupView> {
        val funcionarioCadastrado = funcionarioStartupDtoService.cadastrar(funcionarioStartup)
        val uri = uriComponentsBuilder.path("/funcionariosStartup/${funcionarioCadastrado.id}").build().toUri()
        return ResponseEntity.created(uri).body(funcionarioCadastrado)
    }

    @PutMapping("/{idFuncionarioStartup}")
    @Transactional
    @CacheEvict(value = ["funcionarioStartup"], allEntries = true)
    fun atualizar(@RequestBody @Valid funcionarioStartup: AtualizarFuncionarioStartupForm, @PathVariable idFuncionarioStartup: Long): ResponseEntity<FuncionarioStartupView> = ResponseEntity.ok(funcionarioStartupDtoService.atualizar(funcionarioStartup, idFuncionarioStartup))

    @DeleteMapping("/{idFuncionarioStartup}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["funcionarioStartup"], allEntries = true)
    fun deletar(@PathVariable idFuncionarioStartup: Long) = funcionarioStartupDtoService.deletar(idFuncionarioStartup)
}