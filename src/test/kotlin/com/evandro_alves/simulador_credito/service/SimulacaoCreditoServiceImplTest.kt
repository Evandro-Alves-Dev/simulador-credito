package com.evandro_alves.simulador_credito.service

import com.evandro_alves.simulador_credito.exceptions.ErroNegocioException
import com.evandro_alves.simulador_credito.exceptions.ValidacaoException
import io.mockk.clearAllMocks
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull


class SimulacaoCreditoServiceImplTest {

    private val simulacaoCreditoServiceImpl = SimulacaoCreditoServiceImpl()

    private val simulcaoCreditoPorValorParcela = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorValorParcela()
    private val simulcaoCreditoPorValorParcelaSemValorParcela = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorValorParcelaSemValorParcela()
    private val simulcaoCreditoPorValorParcelaComQuantidadeParcelas = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorValorParcelaComQuantidadeParcelas()
    private val simulacaoCreditoPorDataNascimento = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorDataNascimento()
    private val simulcaoCreditoPorDataNascimentoSemDataNascimento = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorDataNascimentoSemDataNascimento()
    private val simulcaoCreditoPorDataNascimentoComValorEmprestismo = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorDataNascimentoComValorEmprestismo()
    private val simulcaoCreditoPorDataNascimentoComQuantidadeParcelas = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorDataNascimentoComQuantidadeParcelas()
    private val simulcaoCreditoPorQuantidadeParcelas = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorQuantidadeParcelas()
    private val simulcaoCreditoPorQuantidadeParcelasSemQuantidadeParcelas = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorQuantidadeParcelasSemQuantidadeParcelas()
    private val simulcaoCreditoPorQuantidadeParcelasComValorEmprestimo = SimulacaoCreditoServiceImplTesteMock().montarSimulcaoCreditoPorQuantidadeParcelasComValorEmprestimo()

    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_METHOD)
    inner class SimulacaoCreditoPorValorParcela {
        @Test
        fun `deve retornar simulacoes quando os dados estiverem corretos`() {

            val retorno =
                simulacaoCreditoServiceImpl.simularPorValorParcela(simulcaoCreditoPorValorParcela)

            with(retorno) {
                assertNotNull(this)
                assertEquals(6, this.size)
                this.forEach { simulcaoCredito ->
                    assertNotNull(simulcaoCredito.quantidadeParcelas)
                    assertNotNull(simulcaoCredito.valorEmprestimo)
                    assertNotNull(simulcaoCredito.valorTotalJuros)
                    assertNotNull(simulcaoCredito.valorEmprestimo)
                }
            }
        }

        @Test
        fun `deve retornar erro quando o valor emprestimo estiver incorreto`() {
            val campoDeErroEsperado = "valorEmprestimo"
            val mensagemDeErroEsperada = "Valor empréstimo não informado ou menor que 0"

            val retorno =
                assertThrows<ValidacaoException> {
                    simulacaoCreditoServiceImpl.simularPorValorParcela(simulcaoCreditoPorValorParcelaSemValorParcela)
                }

            with(retorno) {
                assertEquals(campoDeErroEsperado, this.campo)
                assertEquals(mensagemDeErroEsperada, this.message)

            }
        }

        @Test
        fun `deve retornar erro quando a quantidade parcela estiver preenchida`() {
            val campoDeErroEsperado = "quantidadeParcelas"
            val mensagemDeErroEsperada = "Quantidade de parcelas não deve ser informada"

            val retorno =
                assertThrows<ValidacaoException> {
                    simulacaoCreditoServiceImpl.simularPorValorParcela(simulcaoCreditoPorValorParcelaComQuantidadeParcelas)
                }

            with(retorno) {
                assertEquals(campoDeErroEsperado, this.campo)
                assertEquals(mensagemDeErroEsperada, this.message)

            }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_METHOD)
    inner class SimulacaoCreditoPorDataNascimento {
        @Test
        fun `deve retronar simulacoes quando os dados estiverem corretos`() {
            val retorno =
                simulacaoCreditoServiceImpl.simularPorDataNascimento(simulacaoCreditoPorDataNascimento)

            with(retorno) {
                assertNotNull(this)
                assertEquals(36, this.size)
                this.forEach { simulcaoCredito ->
                    assertNotNull(simulcaoCredito.quantidadeParcelas)
                    assertNotNull(simulcaoCredito.valorEmprestimo)
                    assertNotNull(simulcaoCredito.valorTotalJuros)
                    assertNotNull(simulcaoCredito.valorEmprestimo)
                }
            }
        }

        @Test
        fun `deve retornar erro quando o data nascimento estiver incorreta`() {
            val mensagemDeErroEsperada = "Erro ao simular por valor parcela."

            val retorno =
                assertThrows<ErroNegocioException> {
                    simulacaoCreditoServiceImpl.simularPorValorParcela(simulcaoCreditoPorDataNascimentoSemDataNascimento)
                }

            with(retorno) {
                assertEquals(mensagemDeErroEsperada, this.message)

            }
        }

        @Test
        fun `deve retornar erro quando o valor emprestimo estiver preenchido`() {
            val campoDeErroEsperado = "valorEmprestimo"
            val mensagemDeErroEsperada = "Valor empréstimo não deve ser informado"

            val retorno =
                assertThrows<ValidacaoException> {
                    simulacaoCreditoServiceImpl.simularPorDataNascimento(simulcaoCreditoPorDataNascimentoComValorEmprestismo)
                }

            with(retorno) {
                assertEquals(campoDeErroEsperado, this.campo)
                assertEquals(mensagemDeErroEsperada, this.message)

            }
        }

        @Test
        fun `deve retornar erro quando a quantidade de parcelas estiver preenchida`() {
            val campoDeErroEsperado = "quantidadeParcelas"
            val mensagemDeErroEsperada = "Quantidade de parcelas não deve ser informada"

            val retorno =
                assertThrows<ValidacaoException> {
                    simulacaoCreditoServiceImpl.simularPorDataNascimento(simulcaoCreditoPorDataNascimentoComQuantidadeParcelas)
                }

            with(retorno) {
                assertEquals(campoDeErroEsperado, this.campo)
                assertEquals(mensagemDeErroEsperada, this.message)

            }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_METHOD)
    inner class SimulacaoCreditoPorQuantidadeParcelas {
        @Test
        fun `deve retronar simulacoes quando os dados estiverem corretos`() {
            val retorno =
                simulacaoCreditoServiceImpl.simularPorQuantidadeParcela(simulcaoCreditoPorQuantidadeParcelas)

            with(retorno) {
                assertNotNull(this)
                assertEquals(6, this.size)
                this.forEach { simulcaoCredito ->
                    assertNotNull(simulcaoCredito.quantidadeParcelas)
                    assertNotNull(simulcaoCredito.valorEmprestimo)
                    assertNotNull(simulcaoCredito.valorTotalJuros)
                    assertNotNull(simulcaoCredito.valorEmprestimo)
                }
            }
        }

        @Test
        fun `deve retornar erro quando a quantidade parcelas estiver incorreta`() {
            val campoDeErroEsperado = "quanditadeParcelas"
            val mensagemDeErroEsperada = "Quantidade de parcelas deve ser informada e deve ser maior que 0"

            val retorno =
                assertThrows<ValidacaoException> {
                    simulacaoCreditoServiceImpl.simularPorQuantidadeParcela(simulcaoCreditoPorQuantidadeParcelasSemQuantidadeParcelas)
                }

            with(retorno) {
                assertEquals(campoDeErroEsperado, this.campo)
                assertEquals(mensagemDeErroEsperada, this.message)

            }
        }

        @Test
        fun `deve retornar erro quando  o valor emprestimo estiver preenchido`() {
            val campoDeErroEsperado = "valorEmprestimo"
            val mensagemDeErroEsperada = "Valor empréstimo não deve ser informado"

            val retorno =
                assertThrows<ValidacaoException> {
                    simulacaoCreditoServiceImpl.simularPorQuantidadeParcela(simulcaoCreditoPorQuantidadeParcelasComValorEmprestimo)
                }

            with(retorno) {
                assertEquals(campoDeErroEsperado, this.campo)
                assertEquals(mensagemDeErroEsperada, this.message)

            }
        }
    }

}