package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.RoleView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleDtoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleService
import jakarta.transaction.Transactional
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
    fun listar(): List<RoleView> = roleDtoService.listar()

    @GetMapping("/{idRole}")
    fun buscarPorId(@PathVariable idRole: Long): RoleView = roleDtoService.buscarPorId(idRole)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody role: NovaRoleForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<RoleView> {
        val roleCadastrada = roleDtoService.cadastrar(role)
        val uri = uriComponentsBuilder.path("/roles/${roleCadastrada.id}").build().toUri()
        return ResponseEntity.created(uri).body(roleCadastrada)
    }

    @PutMapping("/{idRole}")
    @Transactional
    fun atualizar(@RequestBody role: AtualizarRoleForm, @PathVariable idRole: Long): ResponseEntity<RoleView> = ResponseEntity.ok(roleDtoService.atualizar(role, idRole))

    @DeleteMapping("/{idRole}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idRole: Long) = roleDtoService.deletar(idRole)
}