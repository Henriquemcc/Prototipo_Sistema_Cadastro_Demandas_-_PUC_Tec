package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioStartup
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioStartupService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/funcionariosStartup")
class FuncionarioStartupController(
    private val funcionarioStartupService: FuncionarioStartupService
) {

    @GetMapping
    fun listar(): List<FuncionarioStartup> = funcionarioStartupService.listar()

    @GetMapping("/{idFuncionarioStartup}")
    fun buscarPorId(@PathVariable idFuncionarioStartup: Long): FuncionarioStartup = funcionarioStartupService.buscarPorId(idFuncionarioStartup)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody funcionarioStartup: FuncionarioStartup): FuncionarioStartup = funcionarioStartupService.cadastrar(funcionarioStartup)

    @PutMapping("/{idFuncionarioStartup}")
    @Transactional
    fun atualizar(@RequestBody funcionarioStartup: FuncionarioStartup, @PathVariable idFuncionarioStartup: Long): FuncionarioStartup = funcionarioStartupService.atualizar(funcionarioStartup, idFuncionarioStartup)

    @DeleteMapping("/{idFuncionarioStartup}")
    @Transactional
    fun deletar(@PathVariable idFuncionarioStartup: Long) = funcionarioStartupService.deletar(idFuncionarioStartup)
}