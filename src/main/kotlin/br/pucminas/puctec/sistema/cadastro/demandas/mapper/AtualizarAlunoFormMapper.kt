package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Aluno
import br.pucminas.puctec.sistema.cadastro.demandas.service.AreaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.ProfessorService
import org.springframework.stereotype.Component

@Component
class AtualizarAlunoFormMapper(
    private val areaService: AreaService,
    private val pessoaService: PessoaService,
    private val professorService: ProfessorService,
    private val demandaService: DemandaService
): Mapper<AtualizarAlunoForm, Aluno> {
    override fun map(t: AtualizarAlunoForm): Aluno {
        return Aluno(
            area = areaService.buscarPorId(t.areaId),
            curso = t.curso,
            matricula = t.matricula,
            pessoa = pessoaService.buscarPorId(t.pessoaId),
            professorOrientador = professorService.buscarPorId(t.professorOrientadorId),
            demandas = t.demandasId.map { demandaService.buscarPorId(it) }
        )
    }
}