package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.FuncionarioStartupService
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class AtualizarDemandaFormMapper(
    private val alunoService: AlunoService,
    private val demandaService: DemandaService,
    private val funcionarioStartupService: FuncionarioStartupService
): Mapper<AtualizarDemandaForm, Demanda> {
    override fun map(t: AtualizarDemandaForm): Demanda {
        return Demanda(
            descricao = t.descricao,
            dataCriacao = LocalDateTime.now(),
            dataEntrega = t.dataEntrega,
            titulo = t.titulo,
            alunosResponsaveis = t.alunosResponsaveisId.map { alunoService.buscarPorId(it) },
            subdemandas = t.subdemandasId.map { demandaService.buscarPorId(it) },
            funcionariosStartupResponsaveis = t.funcionariosStartupResponsaveisId.map { funcionarioStartupService.buscarPorId(it) }
        )
    }
}