package com.evandro_alves.simulador_credito.service.mapper

import com.evandro_alves.simulador_credito.config.toArredondamento
import com.evandro_alves.simulador_credito.domain.entity.SimulacaoCredito
import java.math.BigDecimal
import java.time.LocalDate


object SimulacaoCreditoServiceMapper {

    fun montarSimulacaoCredito(
        valorSolitado: BigDecimal? = null,
        valorEmprestimo: BigDecimal,
        dataNascimento: LocalDate,
        totalJuros: BigDecimal,
        quantidadeParcelas: Int,
        valorParcela: BigDecimal
    ): SimulacaoCredito {
        return SimulacaoCredito(
            valorSolicitado = valorSolitado?.toArredondamento(),
            valorEmprestimo = valorEmprestimo.toArredondamento(),
            dataNascimento = dataNascimento,
            valorTotalJuros = totalJuros.toArredondamento(),
            quantidadeParcelas = quantidadeParcelas,
            valorParcela = valorParcela.toArredondamento()
        )
    }


}