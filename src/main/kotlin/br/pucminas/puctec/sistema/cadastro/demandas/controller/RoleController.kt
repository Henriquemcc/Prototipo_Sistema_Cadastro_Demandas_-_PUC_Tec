package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.RoleView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleDtoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/roles")
class RoleController(
    private val roleDtoService: RoleDtoService
) {

    @GetMapping
    @Cacheable("roles")
    fun listar(): List<RoleView> = roleDtoService.listar()

    @GetMapping("/{idRole}")
    fun buscarPorId(@PathVariable idRole: Long): RoleView = roleDtoService.buscarPorId(idRole)

    @PostMapping
    @Transactional
    @CacheEvict(value = ["roles"], allEntries = true)
    fun cadastrar(@RequestBody @Valid role: NovaRoleForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<RoleView> {
        val roleCadastrada = roleDtoService.cadastrar(role)
        val uri = uriComponentsBuilder.path("/roles/${roleCadastrada.id}").build().toUri()
        return ResponseEntity.created(uri).body(roleCadastrada)
    }

    @PutMapping("/{idRole}")
    @Transactional
    @CacheEvict(value = ["roles"], allEntries = true)
    fun atualizar(@RequestBody @Valid role: AtualizarRoleForm, @PathVariable idRole: Long): ResponseEntity<RoleView> = ResponseEntity.ok(roleDtoService.atualizar(role, idRole))

    @DeleteMapping("/{idRole}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["roles"], allEntries = true)
    fun deletar(@PathVariable idRole: Long) = roleDtoService.deletar(idRole)
}