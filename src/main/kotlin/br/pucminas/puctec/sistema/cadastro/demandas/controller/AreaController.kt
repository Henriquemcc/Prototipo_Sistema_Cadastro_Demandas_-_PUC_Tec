package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Area
import br.pucminas.puctec.sistema.cadastro.demandas.service.AreaService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/areas")
class AreaController(
    private val areaService: AreaService
) {
    @GetMapping
    fun listar(): List<Area> = areaService.listar()

    @GetMapping("/{idArea}")
    fun buscarPorId(@PathVariable idArea: Long): Area = areaService.buscarPorId(idArea)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody area: Area): Area = areaService.cadastrar(area)

    @PutMapping("/{idArea}")
    @Transactional
    fun atualizar(@RequestBody area: Area, @PathVariable idArea: Long): Area = areaService.atualizar(area, idArea)

    @DeleteMapping("/{idArea}")
    @Transactional
    fun deletar(@PathVariable idArea: Long) = areaService.deletar(idArea)
}