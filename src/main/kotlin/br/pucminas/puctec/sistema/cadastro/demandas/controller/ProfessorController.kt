package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarProfessorForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoProfessorForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.ProfessorView
import br.pucminas.puctec.sistema.cadastro.demandas.service.ProfessorDtoService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/professores")
class ProfessorController(
    private val professorDtoService: ProfessorDtoService
) {

    @GetMapping
    fun listar(): List<ProfessorView> = professorDtoService.listar()

    @GetMapping("/{idProfessor}")
    fun buscarPorId(@PathVariable idProfessor: Long): ProfessorView = professorDtoService.buscarPorId(idProfessor)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody professor: NovoProfessorForm): ProfessorView = professorDtoService.cadastrar(professor)

    @PutMapping("/{idProfessor}")
    @Transactional
    fun atualizar(@RequestBody professor: AtualizarProfessorForm, @PathVariable idProfessor: Long): ProfessorView = professorDtoService.atualizar(professor, idProfessor)

    @DeleteMapping("/{idProfessor}")
    @Transactional
    fun deletar(@PathVariable idProfessor: Long) = professorDtoService.deletar(idProfessor)
}