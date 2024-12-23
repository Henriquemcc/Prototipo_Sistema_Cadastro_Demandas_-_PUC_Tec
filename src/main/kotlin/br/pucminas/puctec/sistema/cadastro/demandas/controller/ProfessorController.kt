package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarProfessorForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoProfessorForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.ProfessorView
import br.pucminas.puctec.sistema.cadastro.demandas.service.ProfessorDtoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/professores")
class ProfessorController(
    private val professorDtoService: ProfessorDtoService
) {

    @GetMapping
    @Cacheable("professores")
    fun listar(): List<ProfessorView> = professorDtoService.listar()

    @GetMapping("/{idProfessor}")
    fun buscarPorId(@PathVariable idProfessor: Long): ProfessorView = professorDtoService.buscarPorId(idProfessor)

    @PostMapping
    @Transactional
    @CacheEvict(value = ["professores"], allEntries = true)
    fun cadastrar(@RequestBody @Valid professor: NovoProfessorForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<ProfessorView> {
        val professorCadastrado = professorDtoService.cadastrar(professor)
        val uri = uriComponentsBuilder.path("/professores/${professorCadastrado.id}").build().toUri()
        return ResponseEntity.created(uri).body(professorCadastrado)
    }

    @PutMapping("/{idProfessor}")
    @Transactional
    @CacheEvict(value = ["professores"], allEntries = true)
    fun atualizar(@RequestBody @Valid professor: AtualizarProfessorForm, @PathVariable idProfessor: Long): ResponseEntity<ProfessorView> = ResponseEntity.ok(professorDtoService.atualizar(professor, idProfessor))

    @DeleteMapping("/{idProfessor}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["professores"], allEntries = true)
    fun deletar(@PathVariable idProfessor: Long) = professorDtoService.deletar(idProfessor)
}