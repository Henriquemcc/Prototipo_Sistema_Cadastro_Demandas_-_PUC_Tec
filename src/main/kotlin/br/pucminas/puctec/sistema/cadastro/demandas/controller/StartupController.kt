package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.StartupView
import br.pucminas.puctec.sistema.cadastro.demandas.service.StartupDtoService
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/startups")
class StartupController(
    private val startupDtoService: StartupDtoService
) {
    @GetMapping
    fun listar(): List<StartupView> = startupDtoService.listar()

    @GetMapping("/{idStartup}")
    fun buscarPorId(@PathVariable idStartup: Long): StartupView = startupDtoService.buscarPorId(idStartup)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody startup: NovaStartupForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<StartupView> {
        val startupCadastrada = startupDtoService.cadastrar(startup)
        val uri = uriComponentsBuilder.path("/startups/${startupCadastrada.id}").build().toUri()
        return ResponseEntity.created(uri).body(startupCadastrada)
    }

    @PutMapping("/{idStartup}")
    @Transactional
    fun atualizar(@RequestBody startup: AtualizarStartupForm, @PathVariable idStartup: Long): ResponseEntity<StartupView> = ResponseEntity.ok(startupDtoService.atualizar(startup, idStartup))

    @DeleteMapping("/{idStartup}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idStartup: Long) = startupDtoService.deletar(idStartup)
}