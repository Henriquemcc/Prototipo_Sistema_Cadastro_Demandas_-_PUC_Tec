package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.DemandaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaDtoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

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
    fun cadastrar(@RequestBody @Valid demanda: NovaDemandaForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<DemandaView> {
        val demandaCadastrada = demandaDtoService.cadastrar(demanda)
        val uri = uriComponentsBuilder.path("/demandas/${demandaCadastrada.id}").build().toUri()
        return ResponseEntity.created(uri).body(demandaCadastrada)
    }

    @PutMapping("/{idDemanda}")
    @Transactional
    fun atualizar(@RequestBody @Valid demanda: AtualizarDemandaForm, @PathVariable idDemanda: Long): ResponseEntity<DemandaView> = ResponseEntity.ok(demandaDtoService.atualizar(demanda, idDemanda))

    @DeleteMapping("/{idDemanda}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idDemanda: Long) = demandaDtoService.deletar(idDemanda)
}