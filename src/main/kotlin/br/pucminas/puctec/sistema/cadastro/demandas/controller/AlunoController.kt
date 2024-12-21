package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AlunoView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoDtoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

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
    fun cadastrar(@RequestBody @Valid aluno: NovoAlunoForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<AlunoView> {
        val alunoCadastrado = alunoDtoService.cadastrar(aluno)
        val uri = uriComponentsBuilder.path("/alunos/${alunoCadastrado.id}").build().toUri()
        return ResponseEntity.created(uri).body(alunoCadastrado)
    }

    @PutMapping("/{idAluno}")
    @Transactional
    fun atualizar(@RequestBody @Valid aluno: AtualizarAlunoForm, @PathVariable idAluno: Long): ResponseEntity<AlunoView> = ResponseEntity.ok(alunoDtoService.atualizar(aluno, idAluno))

    @DeleteMapping("/{idAluno}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idAluno: Long) = alunoDtoService.deletar(idAluno)
}