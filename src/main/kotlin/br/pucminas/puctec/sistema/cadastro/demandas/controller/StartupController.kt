package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.StartupView
import br.pucminas.puctec.sistema.cadastro.demandas.service.StartupDtoService
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
    private val startupViewService: StartupDtoService
) {

    @GetMapping
    fun listar(): List<StartupView> {
        return startupViewService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): StartupView {
        return startupViewService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody form: NovaStartupForm) {
        startupViewService.cadastrar(form)
    }

    @PutMapping("/{idStartup}")
    fun atualizar(@RequestBody form: NovaStartupForm, @PathVariable idStartup: Long) {
        startupViewService.atualizar(form, idStartup)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        startupViewService.deletar(id)
    }

}