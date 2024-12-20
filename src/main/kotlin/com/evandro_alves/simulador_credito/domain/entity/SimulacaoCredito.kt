package com.evandro_alves.simulador_credito.domain.entity

import com.evandro_alves.simulador_credito.enums.TipoSimulacaoEnum
import java.math.BigDecimal
import java.time.LocalDate

data class SimulacaoCredito(
        var valorSolicitado: BigDecimal? = null,
        var valorEmprestimo: BigDecimal? = null,
        val dataNascimento: LocalDate,
        val valorTotalJuros: BigDecimal = BigDecimal.ZERO,
        var valorParcela: BigDecimal = BigDecimal.ZERO,
        var taxaJurosAno: BigDecimal = BigDecimal.ZERO,
        var quantidadeParcelas: Int? = null,
        val tipoSimulacao: TipoSimulacaoEnum? = null
)