package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioPucTecService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/funcionariosPucTec")
class FuncionarioPucTecController(
    private val funcionarioPucTecService: FuncionarioPucTecService
) {

    @GetMapping
    fun listar(): List<FuncionarioPucTec> = funcionarioPucTecService.listar()

    @GetMapping("/{idFuncionarioPucTec}")
    fun buscarPorId(@PathVariable idFuncionarioPucTec: Long): FuncionarioPucTec = funcionarioPucTecService.buscarPorId(idFuncionarioPucTec)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody funcionarioPucTec: FuncionarioPucTec): FuncionarioPucTec = funcionarioPucTecService.cadastrar(funcionarioPucTec)

    @PutMapping("/{idFuncionarioPucTec}")
    @Transactional
    fun atualizar(@RequestBody funcionarioPucTec: FuncionarioPucTec, @PathVariable idFuncionarioPucTec: Long): FuncionarioPucTec = funcionarioPucTecService.atualizar(funcionarioPucTec, idFuncionarioPucTec)

    @DeleteMapping("/{idFuncionarioPucTec}")
    @Transactional
    fun deletar(@PathVariable idFuncionarioPucTec: Long) = funcionarioPucTecService.deletar(idFuncionarioPucTec)
}