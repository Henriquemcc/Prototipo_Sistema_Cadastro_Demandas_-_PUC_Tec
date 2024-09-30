package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Startup
import br.pucminas.puctec.sistema.cadastro.demandas.service.StartupService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/startups")
class StartupController (
    private val startupService: StartupService
) {

    @GetMapping
    fun listar(): List<Startup> {
        return startupService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Startup {
        return startupService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody startup: Startup) {
        startupService.cadastrar(startup)
    }

    @PutMapping("/{idStartup}")
    fun atualizar(@RequestBody startup: Startup, @PathVariable idStartup: Long) {
        startupService.atualizar(startup, idStartup)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        startupService.deletar(id)
    }

}