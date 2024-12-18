package br.pucminas.puctec.sistema.cadastro.demandas.model

import jakarta.persistence.Embeddable
import java.time.Year

@Embeddable
data class Rodada(
    val ano: Year,
    val semestre: Byte
)
