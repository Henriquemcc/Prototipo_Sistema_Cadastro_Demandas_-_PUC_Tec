package br.pucminas.puctec.sistema.cadastro.demandas.service

import br.pucminas.puctec.sistema.cadastro.demandas.dto.AtualizarFuncionarioPucTecForm
import br.pucminas.puctec.sistema.cadastro.demandas.dto.FuncionarioPucTecView
import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovoFuncionarioPucTecForm
import br.pucminas.puctec.sistema.cadastro.demandas.exception.NotFoundException
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.AtualizarFuncionarioPucTecFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.FuncionarioPucTecViewMapper
import br.pucminas.puctec.sistema.cadastro.demandas.mapper.NovoFuncionarioPucTecFormMapper
import br.pucminas.puctec.sistema.cadastro.demandas.model.FuncionarioPucTec
import br.pucminas.puctec.sistema.cadastro.demandas.repository.FuncionarioPucTecRepository
import org.springframework.stereotype.Service

@Service
class FuncionarioPucTecDtoService(
    private val funcionarioPucTecService: FuncionarioPucTecService,
    private val funcionarioPucTecViewMapper: FuncionarioPucTecViewMapper,
    private val atualizarFuncionarioPucTecFormMapper: AtualizarFuncionarioPucTecFormMapper,
    private val novoFuncionarioPucTecFormMapper: NovoFuncionarioPucTecFormMapper
) {

    fun listar(): List<FuncionarioPucTecView> = funcionarioPucTecService.listar().map { funcionarioPucTecViewMapper.map(it) }

    fun buscarPorId(idFuncionarioPucTec: Long): FuncionarioPucTecView = funcionarioPucTecViewMapper.map(funcionarioPucTecService.buscarPorId(idFuncionarioPucTec))

    fun cadastrar(funcionarioPucTec: NovoFuncionarioPucTecForm): FuncionarioPucTecView = funcionarioPucTecViewMapper.map(funcionarioPucTecService.cadastrar(novoFuncionarioPucTecFormMapper.map(funcionarioPucTec)))

    fun atualizar(funcionarioPucTec: AtualizarFuncionarioPucTecForm, idFuncionarioPucTec: Long): FuncionarioPucTecView = funcionarioPucTecViewMapper.map(funcionarioPucTecService.atualizar(atualizarFuncionarioPucTecFormMapper.map(funcionarioPucTec), idFuncionarioPucTec))

    fun deletar(idFuncionarioPucTec: Long) = funcionarioPucTecService.deletar(idFuncionarioPucTec)
}