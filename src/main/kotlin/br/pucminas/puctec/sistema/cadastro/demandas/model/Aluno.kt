package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.*
import jakarta.validation.constraints.Size

@Entity
data class Aluno(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Size(max=100)
    var curso: String,
    @Size(max=10)
    var matricula: String,
    @OneToOne
    var pessoa: Pessoa,
    @ManyToOne
    var area: Area,
    @ManyToMany
    @JoinTable(
        name = "aluno_professores_orientadores",
        joinColumns = [JoinColumn(name = "aluno_id")],
        inverseJoinColumns = [JoinColumn(name = "professor_id")]
    )
    var professoresOrientadores: List<Professor> = mutableListOf(),
    @ManyToMany
    @JoinTable(
        name = "aluno_demanda",
        joinColumns = [JoinColumn(name = "aluno_id")],
        inverseJoinColumns = [JoinColumn(name = "demanda_id")]
    )
    var demandas: List<Demanda>
)