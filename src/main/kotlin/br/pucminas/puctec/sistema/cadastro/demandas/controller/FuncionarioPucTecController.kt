package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarFuncionarioPucTecForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.FuncionarioPucTecView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoFuncionarioPucTecForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioPucTecDtoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioPucTecService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

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
    fun cadastrar(@RequestBody @Valid funcionarioPucTec: NovoFuncionarioPucTecForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<FuncionarioPucTecView> {
        val funcionarioCadastrado = funcionarioPucTecDtoService.cadastrar(funcionarioPucTec)
        val uri = uriComponentsBuilder.path("/funcionariosPucTec/${funcionarioCadastrado.id}").build().toUri()
        return ResponseEntity.created(uri).body(funcionarioCadastrado)
    }

    @PutMapping("/{idFuncionarioPucTec}")
    @Transactional
    fun atualizar(@RequestBody @Valid funcionarioPucTec: AtualizarFuncionarioPucTecForm, @PathVariable idFuncionarioPucTec: Long): ResponseEntity<FuncionarioPucTecView> = ResponseEntity.ok(funcionarioPucTecDtoService.atualizar(funcionarioPucTec, idFuncionarioPucTec))

    @DeleteMapping("/{idFuncionarioPucTec}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idFuncionarioPucTec: Long) = funcionarioPucTecDtoService.deletar(idFuncionarioPucTec)
}