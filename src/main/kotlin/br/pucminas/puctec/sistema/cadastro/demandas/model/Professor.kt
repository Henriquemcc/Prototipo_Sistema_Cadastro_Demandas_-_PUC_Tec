package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne

@Entity
data class Professor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    var area: Area,
    @OneToOne
    var pessoa: Pessoa,
    @ManyToMany(mappedBy = "professoresOrientadores")
    var alunosOrientados: List<Aluno> = mutableListOf()
)