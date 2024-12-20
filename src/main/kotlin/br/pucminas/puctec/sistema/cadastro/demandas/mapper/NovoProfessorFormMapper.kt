package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoProfessorForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Professor
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.AreaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaService
import org.springframework.stereotype.Component

@Component
class NovoProfessorFormMapper(
    private val areaService: AreaService,
    private val pessoaService: PessoaService,
    private val alunoService: AlunoService
): Mapper<NovoProfessorForm, Professor> {
    override fun map(t: NovoProfessorForm): Professor {
        return Professor(
            area = areaService.buscarPorId(t.areaId),
            pessoa = pessoaService.buscarPorId(t.pessoaId),
            alunoOrientado = alunoService.buscarPorId(t.alunoOrientadoId)
        )
    }
}