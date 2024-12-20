package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarFuncionarioStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.FuncionarioStartupView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoFuncionarioStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioStartupDtoService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/funcionariosStartup")
class FuncionarioStartupController(
    private val funcionarioStartupDtoService: FuncionarioStartupDtoService
) {

    @GetMapping
    fun listar(): List<FuncionarioStartupView> = funcionarioStartupDtoService.listar()

    @GetMapping("/{idFuncionarioStartup}")
    fun buscarPorId(@PathVariable idFuncionarioStartup: Long): FuncionarioStartupView = funcionarioStartupDtoService.buscarPorId(idFuncionarioStartup)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody funcionarioStartup: NovoFuncionarioStartupForm): FuncionarioStartupView = funcionarioStartupDtoService.cadastrar(funcionarioStartup)

    @PutMapping("/{idFuncionarioStartup}")
    @Transactional
    fun atualizar(@RequestBody funcionarioStartup: AtualizarFuncionarioStartupForm, @PathVariable idFuncionarioStartup: Long): FuncionarioStartupView = funcionarioStartupDtoService.atualizar(funcionarioStartup, idFuncionarioStartup)

    @DeleteMapping("/{idFuncionarioStartup}")
    @Transactional
    fun deletar(@PathVariable idFuncionarioStartup: Long) = funcionarioStartupDtoService.deletar(idFuncionarioStartup)
}