package br.pucminas.puctec.sistema.cadastro.demandas.repository

import br.pucminas.puctec.sistema.cadastro.demandas.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long>