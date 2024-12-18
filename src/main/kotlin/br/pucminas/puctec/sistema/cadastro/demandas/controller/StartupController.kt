package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import br.pucminas.puctec.sistema.cadastro.demandas.service.StartupService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/startups")
class StartupController(
    private val startupService: StartupService
) {
    @GetMapping
    fun listar(): List<Startup> = startupService.listar()

    @GetMapping("/{idStartup}")
    fun buscarPorId(@PathVariable idStartup: Long): Startup = startupService.buscarPorId(idStartup)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody startup: Startup): Startup = startupService.cadastrar(startup)

    @PutMapping("/{idStartup}")
    @Transactional
    fun atualizar(@RequestBody startup: Startup, @PathVariable idStartup: Long): Startup = startupService.atualizar(startup, idStartup)

    @DeleteMapping("/{idStartup}")
    @Transactional
    fun deletar(@PathVariable idStartup: Long) = startupService.deletar(idStartup)
}