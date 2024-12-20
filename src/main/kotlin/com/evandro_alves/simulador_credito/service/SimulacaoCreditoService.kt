package com.evandro_alves.simulador_credito.service

import com.evandro_alves.simulador_credito.domain.entity.SimulacaoCredito

interface SimulacaoCreditoService {

    fun simularPorValorParcela(
        simulacaoCredito: SimulacaoCredito
    ): List<SimulacaoCredito>

    fun simularPorDataNascimento(
        simulacaoCredito: SimulacaoCredito
    ): List<SimulacaoCredito>

    fun simularPorQuantidadeParcela(
        simulacaoCredito: SimulacaoCredito
    ): List<SimulacaoCredito>
}