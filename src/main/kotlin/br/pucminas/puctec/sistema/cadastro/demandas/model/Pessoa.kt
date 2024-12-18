package br.pucminas.puctec.sistema.cadastro.demandas.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CPF

@Entity
data class Pessoa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Size(max = 100)
    var nome: String,
    @Size(max = 100)
    var sobrenome: String,
    @Size(max = 15) @NotNull @NotEmpty
    var telefone: String,
    @Size(max = 254) @NotNull @NotEmpty
    var email: String,
    @CPF
    var cpf: String,
    var senha: String,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pessoa_role", joinColumns = [JoinColumn(name = "pessoa_id")], inverseJoinColumns = [JoinColumn(name="role_id")])
    val role: List<Role> = mutableListOf()
)