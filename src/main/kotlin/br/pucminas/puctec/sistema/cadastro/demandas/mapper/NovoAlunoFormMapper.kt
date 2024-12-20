package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.service.AreaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.ProfessorService
import org.springframework.stereotype.Component

@Component
class NovoAlunoFormMapper(
    private val areaService: AreaService,
    private val demandaService: DemandaService,
    private val pessoaService: PessoaService,
    private val professorService: ProfessorService
): Mapper<NovoAlunoForm, Aluno> {
    override fun map(t: NovoAlunoForm): Aluno {
        return Aluno(
            matricula = t.matricula,
            area = areaService.buscarPorId(t.areaId),
            curso = t.curso,
            demandas = t.demandasId.map { demandaService.buscarPorId(it) },
            pessoa = pessoaService.buscarPorId(t.pessoaId),
            professoresOrientadores = t.professoresOrientadoresId.map { professorService.buscarPorId(it) },
        )
    }
}