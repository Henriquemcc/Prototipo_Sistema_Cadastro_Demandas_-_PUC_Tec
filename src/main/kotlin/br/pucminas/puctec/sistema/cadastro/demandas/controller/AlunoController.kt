package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
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
    private val alunoService: AlunoService
) {

    @GetMapping
    fun listar(): List<Aluno> {
        return alunoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Aluno {
        return alunoService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody aluno: Aluno) {
        alunoService.cadastrar(aluno)
    }

    @PutMapping("/{idAluno}")
    fun atualizar(@RequestBody aluno: Aluno, @PathVariable idAluno: Long) {
        alunoService.atualizar(aluno, idAluno)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        alunoService.deletar(id)
    }

}