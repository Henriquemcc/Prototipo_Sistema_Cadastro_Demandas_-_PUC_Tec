package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AreaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.service.AreaDtoService
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/areas")
class AreaController(
    private val areaDtoService: AreaDtoService
) {
    @GetMapping
    fun listar(): List<AreaView> = areaDtoService.listar()

    @GetMapping("/{idArea}")
    fun buscarPorId(@PathVariable idArea: Long): AreaView = areaDtoService.buscarPorId(idArea)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody area: NovaAreaForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<AreaView> {
        val areaCadastrada = areaDtoService.cadastrar(area)
        val uri = uriComponentsBuilder.path("/areas/${areaCadastrada.id}").build().toUri()
        return ResponseEntity.created(uri).body(areaCadastrada)
    }

    @PutMapping("/{idArea}")
    @Transactional
    fun atualizar(@RequestBody area: AtualizarAreaForm, @PathVariable idArea: Long): ResponseEntity<AreaView> = ResponseEntity.ok(areaDtoService.atualizar(area, idArea))

    @DeleteMapping("/{idArea}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idArea: Long) = areaDtoService.deletar(idArea)
}