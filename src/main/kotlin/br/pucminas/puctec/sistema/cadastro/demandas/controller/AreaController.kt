package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AreaView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaAreaForm
import br.pucminas.puctec.sistema.cadastro.demandas.service.AreaDtoService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

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
    fun cadastrar(@RequestBody area: NovaAreaForm): AreaView = areaDtoService.cadastrar(area)

    @PutMapping("/{idArea}")
    @Transactional
    fun atualizar(@RequestBody area: AtualizarAreaForm, @PathVariable idArea: Long): AreaView = areaDtoService.atualizar(area, idArea)

    @DeleteMapping("/{idArea}")
    @Transactional
    fun deletar(@PathVariable idArea: Long) = areaDtoService.deletar(idArea)
}