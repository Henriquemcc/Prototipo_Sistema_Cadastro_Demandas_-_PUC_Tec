package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/demandas")
class DemandaController(
    val demandaService: DemandaService
) {
    @GetMapping
    fun listar(): List<Demanda> = demandaService.listar()

    @GetMapping("/{idDemanda}")
    fun buscarPorId(@PathVariable idDemanda: Long): Demanda = demandaService.buscarPorId(idDemanda)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody demanda: Demanda): Demanda = demandaService.cadastrar(demanda)

    @PutMapping("/{idDemanda}")
    @Transactional
    fun atualizar(@RequestBody demanda: Demanda, @PathVariable idDemanda: Long): Demanda = demandaService.atualizar(demanda, idDemanda)

    @DeleteMapping("/{idDemanda}")
    @Transactional
    fun deletar(@PathVariable idDemanda: Long) = demandaService.deletar(idDemanda)
}