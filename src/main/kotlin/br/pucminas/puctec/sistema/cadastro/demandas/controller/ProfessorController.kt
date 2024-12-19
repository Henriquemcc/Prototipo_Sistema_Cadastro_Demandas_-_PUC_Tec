package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Professor
import br.pucminas.puctec.sistema.cadastro.demandas.service.ProfessorService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/professores")
class ProfessorController(
    private val professorService: ProfessorService
) {

    @GetMapping
    fun listar(): List<Professor> = professorService.listar()

    @GetMapping("/{idProfessor}")
    fun buscarPorId(@PathVariable idProfessor: Long): Professor = professorService.buscarPorId(idProfessor)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody professor: Professor): Professor = professorService.cadastrar(professor)

    @PutMapping("/{idProfessor}")
    @Transactional
    fun atualizar(@RequestBody professor: Professor, @PathVariable idProfessor: Long): Professor = professorService.atualizar(professor, idProfessor)

    @DeleteMapping("/{idProfessor}")
    @Transactional
    fun deletar(@PathVariable idProfessor: Long) = professorService.deletar(idProfessor)
}