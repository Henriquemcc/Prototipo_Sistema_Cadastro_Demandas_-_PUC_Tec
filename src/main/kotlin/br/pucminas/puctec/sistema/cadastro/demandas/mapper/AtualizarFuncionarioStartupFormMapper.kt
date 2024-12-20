package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarFuncionarioStartupForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioStartup
import br.pucminas.puctec.sistema.cadastro.demandas.service.DemandaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaService
import br.pucminas.puctec.sistema.cadastro.demandas.service.StartupService
import org.springframework.stereotype.Component

@Component
class AtualizarFuncionarioStartupFormMapper(
    private val demandaService: DemandaService,
    private val pessoaService: PessoaService,
    private val startupService: StartupService
): Mapper<AtualizarFuncionarioStartupForm, FuncionarioStartup> {
    override fun map(t: AtualizarFuncionarioStartupForm): FuncionarioStartup {
        return FuncionarioStartup(
            demandas = t.demandasId.map { demandaService.buscarPorId(it) },
            pessoa = pessoaService.buscarPorId(t.pessoaId),
            startup = startupService.buscarPorId(t.startupId)
        )
    }
}