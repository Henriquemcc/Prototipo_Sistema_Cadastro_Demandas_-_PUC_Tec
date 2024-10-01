package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AlunoView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoAlunoForm
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AlunoFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AlunoViewMapper
import org.springframework.stereotype.Service

@Service
class AlunoViewService(
    private val alunoService: AlunoService,
    private val alunoViewMapper: AlunoViewMapper,
    private val alunoFormMapper: AlunoFormMapper
    ) {

    fun listar(): List<AlunoView> {
        return alunoService.listar().map { a -> alunoViewMapper.map(a) }
    }

    fun buscarPorId(id: Long): AlunoView {
        return alunoViewMapper.map(alunoService.buscarPorId(id))
    }

    fun cadastrar(form: NovoAlunoForm) {
        alunoService.cadastrar(alunoFormMapper.map(form))
    }

    fun atualizar(form: NovoAlunoForm, id: Long) {
        alunoService.atualizar(alunoFormMapper.map(form), id)
    }

    fun deletar(id: Long) {
        alunoService.deletar(id)
    }
}