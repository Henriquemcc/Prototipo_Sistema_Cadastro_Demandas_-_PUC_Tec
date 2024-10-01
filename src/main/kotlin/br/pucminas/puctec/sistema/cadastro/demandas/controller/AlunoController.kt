package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AlunoView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoViewService
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
    private val alunoViewService: AlunoViewService
) {

    @GetMapping
    fun listar(): List<AlunoView> {
        return alunoViewService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AlunoView {
        return alunoViewService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody form: NovoAlunoForm) {
        alunoViewService.cadastrar(form)
    }

    @PutMapping("/{idAluno}")
    fun atualizar(@RequestBody form: NovoAlunoForm, @PathVariable idAluno: Long) {
        alunoViewService.atualizar(form, idAluno)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        alunoViewService.deletar(id)
    }

}