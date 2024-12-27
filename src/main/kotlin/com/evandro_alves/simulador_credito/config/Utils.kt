package com.evandro_alves.simulador_credito.config

import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.toArredondamento(): BigDecimal {
    return this.setScale(2, RoundingMode.HALF_EVEN)
}

fun BigDecimal.toArredondamentoTaxa(): BigDecimal {
    return this.setScale(10, RoundingMode.HALF_EVEN)
}