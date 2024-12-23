package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AreaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.service.AreaDtoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
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
    @Cacheable("areas")
    fun listar(): List<AreaView> = areaDtoService.listar()

    @GetMapping("/{idArea}")
    fun buscarPorId(@PathVariable idArea: Long): AreaView = areaDtoService.buscarPorId(idArea)

    @PostMapping
    @Transactional
    @CacheEvict(value = ["areas"], allEntries = true)
    fun cadastrar(@RequestBody @Valid area: NovaAreaForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<AreaView> {
        val areaCadastrada = areaDtoService.cadastrar(area)
        val uri = uriComponentsBuilder.path("/areas/${areaCadastrada.id}").build().toUri()
        return ResponseEntity.created(uri).body(areaCadastrada)
    }

    @PutMapping("/{idArea}")
    @Transactional
    @CacheEvict(value = ["areas"], allEntries = true)
    fun atualizar(@RequestBody @Valid area: AtualizarAreaForm, @PathVariable idArea: Long): ResponseEntity<AreaView> = ResponseEntity.ok(areaDtoService.atualizar(area, idArea))

    @DeleteMapping("/{idArea}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["areas"], allEntries = true)
    fun deletar(@PathVariable idArea: Long) = areaDtoService.deletar(idArea)
}