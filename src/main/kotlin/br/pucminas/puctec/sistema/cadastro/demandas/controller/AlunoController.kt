package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AlunoView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoDtoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alunos")
class AlunoController(
    private val alunoDtoService: AlunoDtoService
) {
    @GetMapping
    fun listar(): List<AlunoView> = alunoDtoService.listar()

    @GetMapping("/{idAluno}")
    fun buscarPorId(@PathVariable idAluno: Long): AlunoView = alunoDtoService.buscarPorId(idAluno)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody aluno: NovoAlunoForm): AlunoView = alunoDtoService.cadastrar(aluno)

    @PutMapping("/{idAluno}")
    @Transactional
    fun atualizar(@RequestBody aluno: AtualizarAlunoForm, @PathVariable idAluno: Long): AlunoView = alunoDtoService.atualizar(aluno, idAluno)

    @DeleteMapping("/{idAluno}")
    @Transactional
    fun deletar(@PathVariable idAluno: Long) = alunoDtoService.deletar(idAluno)
}