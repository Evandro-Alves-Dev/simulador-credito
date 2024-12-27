package com.evandro_alves.simulador_credito.service

import com.evandro_alves.simulador_credito.domain.entity.SimulacaoCredito
import com.evandro_alves.simulador_credito.enums.TipoSimulacaoEnum
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SimulacaoCreditoServiceImplTesteMock {

    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val dataNascimento = LocalDate.parse("01-01-1990", formatter)

    // Mocks para o endpoint de simulação de crédito por valor de parcela
    fun montarSimulcaoCreditoPorValorParcela(): SimulacaoCredito = SimulacaoCredito(
        valorEmprestimo = BigDecimal(1000.00),
        dataNascimento = dataNascimento,
        tipoSimulacao = TipoSimulacaoEnum.SVP
    )

    fun montarSimulcaoCreditoPorValorParcelaSemValorParcela(): SimulacaoCredito = SimulacaoCredito(
        valorEmprestimo = null,
        dataNascimento = dataNascimento,
        tipoSimulacao = TipoSimulacaoEnum.SVP
    )

    fun montarSimulcaoCreditoPorValorParcelaComQuantidadeParcelas(): SimulacaoCredito = SimulacaoCredito(
        valorEmprestimo = BigDecimal(1000.00),
        dataNascimento = dataNascimento,
        quantidadeParcelas = 12,
        tipoSimulacao = TipoSimulacaoEnum.SVP
    )

    // Mocks para o endpoint de simulação de crédito por data de nascimento
    fun montarSimulcaoCreditoPorDataNascimento(): SimulacaoCredito = SimulacaoCredito(
        dataNascimento = dataNascimento,
        tipoSimulacao = TipoSimulacaoEnum.SDN
    )

    fun montarSimulcaoCreditoPorDataNascimentoSemDataNascimento(): SimulacaoCredito = SimulacaoCredito(
        dataNascimento = LocalDate.of(1990, 1, 1),
        tipoSimulacao = TipoSimulacaoEnum.SDN
    )

    fun montarSimulcaoCreditoPorDataNascimentoComValorEmprestismo(): SimulacaoCredito = SimulacaoCredito(
        dataNascimento = dataNascimento,
        valorEmprestimo = BigDecimal(1000.00),
        tipoSimulacao = TipoSimulacaoEnum.SDN
    )

    fun montarSimulcaoCreditoPorDataNascimentoComQuantidadeParcelas(): SimulacaoCredito = SimulacaoCredito(
        dataNascimento = dataNascimento,
        quantidadeParcelas = 12,
        tipoSimulacao = TipoSimulacaoEnum.SDN
    )

    // Mocks para o endpoint de simulação de crédito por quantidade de parcelas
    fun montarSimulcaoCreditoPorQuantidadeParcelas(): SimulacaoCredito = SimulacaoCredito(
        quantidadeParcelas = 24,
        dataNascimento = dataNascimento,
        tipoSimulacao = TipoSimulacaoEnum.SQP
    )

    fun montarSimulcaoCreditoPorQuantidadeParcelasSemQuantidadeParcelas(): SimulacaoCredito = SimulacaoCredito(
        quantidadeParcelas = 0,
        dataNascimento = dataNascimento,
        tipoSimulacao = TipoSimulacaoEnum.SQP
    )

    fun montarSimulcaoCreditoPorQuantidadeParcelasComValorEmprestimo(): SimulacaoCredito = SimulacaoCredito(
        quantidadeParcelas = 24,
        dataNascimento = dataNascimento,
        valorEmprestimo = BigDecimal(1000.00),
        tipoSimulacao = TipoSimulacaoEnum.SQP
    )
}