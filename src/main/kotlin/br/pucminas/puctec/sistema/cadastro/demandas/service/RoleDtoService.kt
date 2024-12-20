package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaRoleForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.RoleView
import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarRoleFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovaRoleFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.RoleViewMapper
import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import br.pucminas.puctec.sistema.cadastro.demandas.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleDtoService(
    private val roleService: RoleService,
    private val roleViewMapper: RoleViewMapper,
    private val novaRoleFormMapper: NovaRoleFormMapper,
    private val atualizarRoleFormMapper: AtualizarRoleFormMapper
) {

    fun listar(): List<RoleView> = roleService.listar().map { roleViewMapper.map(it) }

    fun buscarPorId(idRole: Long): RoleView = roleViewMapper.map(roleService.buscarPorId(idRole))

    fun cadastrar(role: NovaRoleForm): RoleView = roleViewMapper.map(roleService.cadastrar(novaRoleFormMapper.map(role)))

    fun atualizar(role: AtualizarRoleForm, idRole: Long): RoleView = roleViewMapper.map(roleService.atualizar(atualizarRoleFormMapper.map(role), idRole))

    fun deletar(idRole: Long) = roleService.deletar(idRole)
}