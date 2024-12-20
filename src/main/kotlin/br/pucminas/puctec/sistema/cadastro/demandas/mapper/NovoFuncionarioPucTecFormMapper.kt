package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoFuncionarioPucTecForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import br.pucminas.puctec.sistema.cadastro.demandas.service.PessoaService
import org.springframework.stereotype.Component

@Component
class NovoFuncionarioPucTecFormMapper(
    private val pessoaService: PessoaService
): Mapper<NovoFuncionarioPucTecForm, FuncionarioPucTec> {
    override fun map(t: NovoFuncionarioPucTecForm): FuncionarioPucTec {
        return FuncionarioPucTec(
            pessoa = pessoaService.buscarPorId(t.pessoaId),
        )
    }
}