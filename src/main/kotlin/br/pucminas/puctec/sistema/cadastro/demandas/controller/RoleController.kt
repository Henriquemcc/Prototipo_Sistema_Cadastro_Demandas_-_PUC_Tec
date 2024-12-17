package br.pucminas.puctec.sistema.cadastro.demandas.controller

import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import br.pucminas.puctec.sistema.cadastro.demandas.service.RoleService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/roles")
class RoleController(
    private val roleService: RoleService
) {

    @GetMapping
    fun listar(): List<Role> = roleService.listar()

    @GetMapping("/{idRole}")
    fun buscarPorId(@PathVariable idRole: Long): Role = roleService.buscarPorId(idRole)

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody role: Role): Role = roleService.cadastrar(role)

    @PutMapping("/{idRole}")
    @Transactional
    fun atualizar(@RequestBody role: Role, @PathVariable idRole: Long): Role = roleService.atualizar(role, idRole)

    @DeleteMapping("/{idRole}")
    @Transactional
    fun deletar(@PathVariable idRole: Long) = roleService.deletar(idRole)
}