package com.evandro_alves.simulador_credito.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class SimulacaoRequest(
        val valorEmprestimo: BigDecimal? = null,
        val quantidadeParcelas: Int? = null,

        @NotNull(message = "Data de nascimento é obrigatória")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @Valid
        val dataNascimento: LocalDate
)
