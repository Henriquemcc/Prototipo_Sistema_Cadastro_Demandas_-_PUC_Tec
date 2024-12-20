package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.FuncionarioPucTecView
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import org.springframework.stereotype.Component

@Component
class FuncionarioPucTecViewMapper: Mapper<FuncionarioPucTec, FuncionarioPucTecView> {
    override fun map(t: FuncionarioPucTec): FuncionarioPucTecView {
        return FuncionarioPucTecView(
            id = t.id,
            pessoaId = t.pessoa.id
        )
    }
}