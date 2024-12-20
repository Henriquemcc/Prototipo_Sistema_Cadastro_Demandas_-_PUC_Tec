package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.DemandaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaDtoService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/demandas")
class DemandaController(
    val demandaDtoService: DemandaDtoService
) {
    @GetMapping
    fun listar(): List<DemandaView> = demandaDtoService.listar()

    @GetMapping("/{idDemanda}")
    fun buscarPorId(@PathVariable idDemanda: Long): DemandaView = demandaDtoService.buscarPorId(idDemanda)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody demanda: NovaDemandaForm): DemandaView = demandaDtoService.cadastrar(demanda)

    @PutMapping("/{idDemanda}")
    @Transactional
    fun atualizar(@RequestBody demanda: AtualizarDemandaForm, @PathVariable idDemanda: Long): DemandaView = demandaDtoService.atualizar(demanda, idDemanda)

    @DeleteMapping("/{idDemanda}")
    @Transactional
    fun deletar(@PathVariable idDemanda: Long) = demandaDtoService.deletar(idDemanda)
}