package com.evandro_alves.simulador_credito.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal
import java.time.LocalDate

data class SimulacaoRequest(
        @Positive(message = "Valor do empréstimo deve ser maior que zero")
        val valorEmprestimo: BigDecimal? = null,

        @Positive(message = "Quantidade de parcelas deve ser maior que zero")
        val quantidadeParcelas: Int? = null,

        @NotNull(message = "Data de nascimento é obrigatória")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        val dataNascimento: LocalDate
)
