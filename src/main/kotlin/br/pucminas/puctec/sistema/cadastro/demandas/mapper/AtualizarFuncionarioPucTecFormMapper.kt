package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarFuncionarioPucTecForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaService
import org.springframework.stereotype.Component

@Component
class AtualizarFuncionarioPucTecFormMapper(
    private val pessoaService: PessoaService
): Mapper<AtualizarFuncionarioPucTecForm, FuncionarioPucTec> {
    override fun map(t: AtualizarFuncionarioPucTecForm): FuncionarioPucTec {
        return FuncionarioPucTec(
            pessoa = pessoaService.buscarPorId(t.pessoaId)
        )
    }
}