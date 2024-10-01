package br.pucminas.puctec.sistema.cadastro.demandas.mapper

import br.pucminas.puctec.sistema.cadastro.demandas.dto.NovaDemandaForm
import br.pucminas.puctec.sistema.cadastro.demandas.model.Demanda
import br.pucminas.puctec.sistema.cadastro.demandas.service.AlunoService
import br.pucminas.puctec.sistema.cadastro.demandas.service.StartupService
import java.time.LocalDateTime

class DemandaFormMapper(
    private val alunoService: AlunoService,
    private val startupService: StartupService,
): Mapper<NovaDemandaForm, Demanda>
 {
    override fun map(form: NovaDemandaForm): Demanda {
        return Demanda(Long.MIN_VALUE, form.titulo, form.descricao, form.idAlunos.map { idA -> alunoService.buscarPorId(idA) }, startupService.buscarPorId(form.idStartup), LocalDateTime.now(), form.dataEntrega)
    }
}