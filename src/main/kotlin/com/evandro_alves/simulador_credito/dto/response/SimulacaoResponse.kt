package com.evandro_alves.simulador_credito.dto.response

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SimulacaoResponse(
        val valorSolicitado: BigDecimal? = null,
        val valorTotal: BigDecimal,
        val valorTotalJuros: BigDecimal,
        val valorParcela: BigDecimal,
        val quantidadeParcelas: Int
)
