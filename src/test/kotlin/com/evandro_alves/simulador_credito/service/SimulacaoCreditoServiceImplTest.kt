package com.evandro_alves.simulador_credito.service

import com.evandro_alves.simulador_credito.domain.entity.SimulacaoCredito
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigDecimal
import java.time.LocalDate


class SimulacaoCreditoServiceImplTest {

    private val simulacaoCreditoServiceImpl = SimulacaoCreditoServiceImpl()

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_METHOD)
    inner class SimulacaoCreditoPorValorParcela {
        @Test
        fun `deve retornar simulacoes quando os dados estiverem corretos`() {
            val simulcaoCredito = SimulacaoCredito(
                valorEmprestimo = BigDecimal(1000.00),
                dataNascimento = LocalDate.of(1990, 1, 1),
            )

            val retorno =
                simulacaoCreditoServiceImpl.simularPorValorParcela(simulcaoCredito)

            with(retorno) {
                assertNotNull(this)
                assertEquals(6, this.size)
                this.forEach { simulcaoCredito ->
                    assertEquals(12, simulcaoCredito.quantidadeParcelas)
                    assertNotNull(simulcaoCredito.valorEmprestimo)
                    assertNotNull(simulcaoCredito.valorTotalJuros)
                    assertNotNull(simulcaoCredito.valorEmprestimo)
                }
            }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_METHOD)
    inner class SimulacaoCreditoPorDataNascimento {
        @Test
        fun `deve retronar simulacoes quando os dados estiverem corretos`() {

        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_METHOD)
    inner class SimulacaoCreditoPorQuantidadeParcelas {
        @Test
        fun `deve retronar simulacoes quando os dados estiverem corretos`() {

        }
    }

}