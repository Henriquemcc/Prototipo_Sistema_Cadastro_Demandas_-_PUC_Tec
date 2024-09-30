package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/demandas")
class DemandaController (
    private val demandaService: DemandaService
) {

    @GetMapping
    fun listar(): List<Demanda> {
        return demandaService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Demanda {
        return demandaService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody demanda: Demanda) {
        demandaService.cadastrar(demanda)
    }

    @PutMapping("/{idDemanda}")
    fun atualizar(@RequestBody demanda: Demanda, @PathVariable idDemanda: Long) {
        demandaService.atualizar(demanda, idDemanda)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        demandaService.deletar(id)
    }
}