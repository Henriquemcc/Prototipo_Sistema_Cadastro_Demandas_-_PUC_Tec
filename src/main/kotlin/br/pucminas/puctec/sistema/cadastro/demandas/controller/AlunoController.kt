package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AlunoView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoDtoService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/alunos")
class AlunoController(
    private val alunoDtoService: AlunoDtoService
) {

    @GetMapping
    fun listar(): List<AlunoView> {
        return alunoDtoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AlunoView {
        return alunoDtoService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody form: NovoAlunoForm) {
        alunoDtoService.cadastrar(form)
    }

    @PutMapping("/{idAluno}")
    fun atualizar(@RequestBody form: NovoAlunoForm, @PathVariable idAluno: Long) {
        alunoDtoService.atualizar(form, idAluno)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        alunoDtoService.deletar(id)
    }

}