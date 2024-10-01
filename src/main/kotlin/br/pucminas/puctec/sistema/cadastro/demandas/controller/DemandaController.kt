package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.DemandaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaViewService
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
    private val demandaViewService: DemandaViewService
) {

    @GetMapping
    fun listar(): List<DemandaView> {
        return demandaViewService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): DemandaView {
        return demandaViewService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody form: NovaDemandaForm) {
        demandaViewService.cadastrar(form)
    }

    @PutMapping("/{idDemanda}")
    fun atualizar(@RequestBody form: NovaDemandaForm, @PathVariable idDemanda: Long) {
        demandaViewService.atualizar(form, idDemanda)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        demandaViewService.deletar(id)
    }
}