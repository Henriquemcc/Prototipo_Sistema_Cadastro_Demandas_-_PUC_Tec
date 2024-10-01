package br.pucminas.puctec.sistema.cadastro.demandas.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}