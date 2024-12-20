package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarFuncionarioPucTecForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.FuncionarioPucTecView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoFuncionarioPucTecForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioPucTecDtoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioPucTecService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/funcionariosPucTec")
class FuncionarioPucTecController(
    private val funcionarioPucTecDtoService: FuncionarioPucTecDtoService
) {

    @GetMapping
    fun listar(): List<FuncionarioPucTecView> = funcionarioPucTecDtoService.listar()

    @GetMapping("/{idFuncionarioPucTec}")
    fun buscarPorId(@PathVariable idFuncionarioPucTec: Long): FuncionarioPucTecView = funcionarioPucTecDtoService.buscarPorId(idFuncionarioPucTec)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody funcionarioPucTec: NovoFuncionarioPucTecForm): FuncionarioPucTecView = funcionarioPucTecDtoService.cadastrar(funcionarioPucTec)

    @PutMapping("/{idFuncionarioPucTec}")
    @Transactional
    fun atualizar(@RequestBody funcionarioPucTec: AtualizarFuncionarioPucTecForm, @PathVariable idFuncionarioPucTec: Long): FuncionarioPucTecView = funcionarioPucTecDtoService.atualizar(funcionarioPucTec, idFuncionarioPucTec)

    @DeleteMapping("/{idFuncionarioPucTec}")
    @Transactional
    fun deletar(@PathVariable idFuncionarioPucTec: Long) = funcionarioPucTecDtoService.deletar(idFuncionarioPucTec)
}