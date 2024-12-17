package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import br.pucminas.puctec.sistema.cadastro.demandas.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val roleRepository: RoleRepository,
    private val notFoundMessage: String = "Role (Papel) não encontrado!"
) {

    fun listar(): List<Role> = roleRepository.findAll()

    fun buscarPorId(idRole: Long): Role = roleRepository.findById(idRole).orElseThrow{ NotFoundException(notFoundMessage) }

    fun cadastrar(role: Role): Role {
        roleRepository.save(role)
        return role
    }

    fun atualizar(role: Role, idRole: Long): Role {
        val roleAnterior = roleRepository.findById(idRole).orElseThrow{ NotFoundException(notFoundMessage) }
        roleAnterior.nome = role.nome
        return roleAnterior
    }

    fun deletar(idRole: Long) = roleRepository.deleteById(idRole)
}