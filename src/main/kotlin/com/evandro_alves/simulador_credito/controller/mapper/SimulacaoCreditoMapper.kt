package com.evandro_alves.simulador_credito.controller.mapper

import com.evandro_alves.simulador_credito.dto.request.SimulacaoRequest
import com.evandro_alves.simulador_credito.dto.response.SimulacaoResponse
import com.evandro_alves.simulador_credito.domain.entity.SimulacaoCredito
import com.evandro_alves.simulador_credito.enums.TipoSimulacaoEnum

fun SimulacaoRequest.toSimuladorCredito(tipoSimulacaoEnum: TipoSimulacaoEnum): SimulacaoCredito {
    return SimulacaoCredito(
        valorEmprestimo = this.valorEmprestimo,
        dataNascimento = this.dataNascimento,
        quantidadeParcelas = this.quantidadeParcelas,
        tipoSimulacao = tipoSimulacaoEnum
    )
}

fun List<SimulacaoCredito>.toSimulacoesResponse(): List<SimulacaoResponse> {
    return this.map { it.toSimulacoesResponse() }
}

fun SimulacaoCredito.toSimulacoesResponse(): SimulacaoResponse {
    return SimulacaoResponse(
        valorSolicitado = this.valorSolicitado,
        valorTotal = this.valorEmprestimo!!,
        valorTotalJuros = this.valorTotalJuros,
        valorParcela = this.valorParcela,
        quantidadeParcelas = this.quantidadeParcelas!!
    )
}