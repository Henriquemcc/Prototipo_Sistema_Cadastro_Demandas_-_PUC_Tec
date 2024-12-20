package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarProfessorForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Professor
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.AreaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaService
import org.springframework.stereotype.Component

@Component
class AtualizarProfessorFormMapper(
    private val areaService: AreaService,
    private val pessoaService: PessoaService,
    private val alunoService: AlunoService
): Mapper<AtualizarProfessorForm, Professor> {
    override fun map(t: AtualizarProfessorForm): Professor {
        return Professor(
            area = areaService.buscarPorId(t.areaId),
            pessoa = pessoaService.buscarPorId(t.pessoaId),
            alunosOrientados = t.alunosOrientadosId.map { alunoService.buscarPorId(it) }
        )
    }
}