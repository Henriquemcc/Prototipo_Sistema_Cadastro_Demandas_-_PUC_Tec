package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alunos")
class AlunoController(
    private val alunoService: AlunoService
) {
    @GetMapping
    fun listar(): List<Aluno> = alunoService.listar()

    @GetMapping("/{idAluno}")
    fun buscarPorId(@PathVariable idAluno: Long): Aluno = alunoService.buscarPorId(idAluno)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody aluno: Aluno): Aluno = alunoService.cadastrar(aluno)

    @PutMapping("/{idAluno}")
    @Transactional
    fun atualizar(@RequestBody aluno: Aluno, @PathVariable idAluno: Long): Aluno = alunoService.atualizar(aluno, idAluno)

    @DeleteMapping("/{idAluno}")
    @Transactional
    fun deletar(@PathVariable idAluno: Long) = alunoService.deletar(idAluno)
}