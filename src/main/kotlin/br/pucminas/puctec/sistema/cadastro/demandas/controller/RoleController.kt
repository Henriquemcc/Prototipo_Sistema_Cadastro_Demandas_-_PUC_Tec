package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.RoleView
import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleDtoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

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
    fun cadastrar(@RequestBody role: NovaRoleForm): RoleView = roleDtoService.cadastrar(role)

    @PutMapping("/{idRole}")
    @Transactional
    fun atualizar(@RequestBody role: AtualizarRoleForm, @PathVariable idRole: Long): RoleView = roleDtoService.atualizar(role, idRole)

    @DeleteMapping("/{idRole}")
    @Transactional
    fun deletar(@PathVariable idRole: Long) = roleDtoService.deletar(idRole)
}