package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.StartupView
import br.pucminas.puctec.sistema.cadastro.demandas.service.StartupDtoService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

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
    fun cadastrar(@RequestBody startup: NovaStartupForm): StartupView = startupDtoService.cadastrar(startup)

    @PutMapping("/{idStartup}")
    @Transactional
    fun atualizar(@RequestBody startup: AtualizarStartupForm, @PathVariable idStartup: Long): StartupView = startupDtoService.atualizar(startup, idStartup)

    @DeleteMapping("/{idStartup}")
    @Transactional
    fun deletar(@PathVariable idStartup: Long) = startupDtoService.deletar(idStartup)
}