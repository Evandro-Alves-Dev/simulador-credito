package com.evandro_alves.simulador_credito.service

import com.evandro_alves.simulador_credito.config.Constantes
import com.evandro_alves.simulador_credito.domain.entity.SimulacaoCredito
import com.evandro_alves.simulador_credito.enums.LogCodeEnum
import com.evandro_alves.simulador_credito.enums.MensagensEnum
import com.evandro_alves.simulador_credito.exceptions.ErroNegocioException
import com.evandro_alves.simulador_credito.exceptions.ValidacaoException
import com.evandro_alves.simulador_credito.service.mapper.SimulacaoCreditoServiceMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.time.LocalDate

@Service
class SimulacaoCreditoServiceImpl(
) : SimulacaoCreditoService {
    private val logger = LoggerFactory.getLogger(SimulacaoCreditoServiceImpl::class.java)

    companion object {
        private val LOG_NEGOCIO = LogCodeEnum.LOGICA_NEGOCIO.codigo
        private val ERRO_NEGOCIO = LogCodeEnum.ERRO_NEGOCIO.codigo
        val quantidadeParcelasPadrao = listOf(12, 24, 36, 48, 60, 84)
        val valoresEmprestimo = listOf(
            BigDecimal(1000),
            BigDecimal(2000),
            BigDecimal(3000),
            BigDecimal(4000),
            BigDecimal(5000),
            BigDecimal(10000)
        )
    }

    override fun simularPorValorParcela(simulacaoCredito: SimulacaoCredito): List<SimulacaoCredito> {
        try {
            logger.info(LOG_NEGOCIO.plus(" - ").plus(MensagensEnum.INI_PRO.descricao))

            /*
            Aqui pode ter uma chamada para um Micro serviço externo que faça a elegibilidade do cliente.
            No retorno terá a um atributo boleano que indica se o cliente é elegivel ou não.
            Caso não seja elegivel terá o(s) motivo(s)
             */

            validacaoDadosEntrada(simulacaoCredito)
            calcularIdade(simulacaoCredito)

            val listaSimulacoesRealizadas = mutableListOf<SimulacaoCredito>()

            /*
            Aqui pode ter uma chamada para um Micro serviço externo que faça os calculos de simulação de crédito.
            No retorno terá a lista de simulações realizadas.
             */

            quantidadeParcelasPadrao.forEach { qtdParcelaPadrao ->
                val valorParcela = calcularParcelaFixa(
                    simulacaoCredito.valorEmprestimo!!,
                    simulacaoCredito.taxaJurosAno,
                    qtdParcelaPadrao
                )

                val valorEmpretimo = valorParcela.multiply(qtdParcelaPadrao.toBigDecimal())
                val totalJuros = valorEmpretimo - simulacaoCredito.valorEmprestimo!!

                val simulacao = SimulacaoCreditoServiceMapper.montarSimulacaoCredito(
                    valorEmprestimo = valorEmpretimo,
                    dataNascimento = simulacaoCredito.dataNascimento,
                    totalJuros = totalJuros,
                    quantidadeParcelas = qtdParcelaPadrao,
                    valorParcela = valorParcela
                )
                listaSimulacoesRealizadas.add(simulacao)
            }

            logger.info(LOG_NEGOCIO.plus(" - ").plus(MensagensEnum.FIM_PRO.descricao))
            return listaSimulacoesRealizadas

        } catch (e: ValidacaoException) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(e.message))
            throw e
        } catch (e: Exception) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(e.message))
            throw ErroNegocioException("Erro ao simular por data de nascimento")
        }
    }

    override fun simularPorDataNascimento(simulacaoCredito: SimulacaoCredito): List<SimulacaoCredito> {
        try {
            logger.info(LOG_NEGOCIO.plus(" - ").plus(MensagensEnum.INI_PRO.descricao))

            validacaoDadosEntrada(simulacaoCredito)
            calcularIdade(simulacaoCredito)

            val listaSimulacoesRealizadas = mutableListOf<SimulacaoCredito>()

            quantidadeParcelasPadrao.forEach { qtdParcelaPadrao ->
                valoresEmprestimo.forEach { valorEmprestimoPadrao ->
                    val valorParcela =
                        calcularParcelaFixa(valorEmprestimoPadrao, simulacaoCredito.taxaJurosAno, qtdParcelaPadrao)

                    val valorEmpretimo = valorParcela.multiply(qtdParcelaPadrao.toBigDecimal())
                    val totalJuros = valorEmpretimo - valorEmprestimoPadrao

                    val simulacao = SimulacaoCreditoServiceMapper.montarSimulacaoCredito(
                        valorSolitado = valorEmprestimoPadrao,
                        valorEmprestimo = valorEmpretimo,
                        dataNascimento = simulacaoCredito.dataNascimento,
                        totalJuros = totalJuros,
                        quantidadeParcelas = qtdParcelaPadrao,
                        valorParcela = valorParcela
                    )
                    listaSimulacoesRealizadas.add(simulacao)
                }
            }

            logger.info(LOG_NEGOCIO.plus(" - ").plus(MensagensEnum.FIM_PRO.descricao))
            return listaSimulacoesRealizadas

        } catch (e: ValidacaoException) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(e.message))
            throw e
        } catch (e: Exception) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(e.message))
            throw ErroNegocioException("Erro ao simular por data de nascimento")
        }
    }

    override fun simularPorQuantidadeParcela(simulacaoCredito: SimulacaoCredito): List<SimulacaoCredito> {
        try {
            logger.info(LOG_NEGOCIO.plus(" - ").plus(MensagensEnum.INI_PRO.descricao))

            validacaoDadosEntrada(simulacaoCredito)
            calcularIdade(simulacaoCredito)

            val listaSimulacoesRealizadas = mutableListOf<SimulacaoCredito>()

            valoresEmprestimo.forEach { valorEmprestimoPadrao ->
                val valorParcela = calcularParcelaFixa(
                    valorEmprestimoPadrao,
                    simulacaoCredito.taxaJurosAno,
                    simulacaoCredito.quantidadeParcelas!!
                )

                val valorEmpretimo = valorParcela.multiply(simulacaoCredito.quantidadeParcelas!!.toBigDecimal())
                val totalJuros = valorEmpretimo - valorEmprestimoPadrao

                val simulacao = SimulacaoCreditoServiceMapper.montarSimulacaoCredito(
                    valorSolitado = valorEmprestimoPadrao,
                    valorEmprestimo = valorEmpretimo,
                    dataNascimento = simulacaoCredito.dataNascimento,
                    totalJuros = totalJuros,
                    quantidadeParcelas = simulacaoCredito.quantidadeParcelas!!,
                    valorParcela = valorParcela
                )
                listaSimulacoesRealizadas.add(simulacao)
            }

            logger.info(LOG_NEGOCIO.plus(" - ").plus(MensagensEnum.FIM_PRO.descricao))
            return listaSimulacoesRealizadas

        } catch (e: ValidacaoException) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(e.message))
            throw e
        } catch (e: Exception) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(e.message))
            throw ErroNegocioException("Erro ao simular por data de nascimento")
        }
    }

    private fun validacaoDadosEntrada(simulacaoCredito: SimulacaoCredito) {
        when (simulacaoCredito.tipoSimulacao!!.name) {
            "SVP" -> validacaoValorParcela(simulacaoCredito)
            "SDN" -> validacaoDataNascimento(simulacaoCredito)
            "SQP" -> validacaoQuantidadeParcelas(simulacaoCredito)
        }
    }

    private fun validacaoValorParcela(simulacaoCredito: SimulacaoCredito) {
        if (simulacaoCredito.valorEmprestimo == null || simulacaoCredito.valorEmprestimo!! <= BigDecimal.ZERO) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(MensagensEnum.VLR_EMP_NUL.descricao))
            throw ValidacaoException(MensagensEnum.VLR_EMP_NUL.descricao, "valorEmprestimo")
        } else if (simulacaoCredito.quantidadeParcelas != null) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(MensagensEnum.QTD_PAR_NULL.descricao))
            throw ValidacaoException(MensagensEnum.QTD_PAR_NULL.descricao, "quantidadeParcelas")
        }
    }

    private fun validacaoDataNascimento(simulacaoCredito: SimulacaoCredito) {
        if (simulacaoCredito.valorEmprestimo != null) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(MensagensEnum.VLR_EMP_NAO_NUL.descricao))
            throw ValidacaoException(MensagensEnum.VLR_EMP_NAO_NUL.descricao, "valorEmprestimo")
        } else if (simulacaoCredito.quantidadeParcelas != null) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(MensagensEnum.QTD_PAR_NULL.descricao))
            throw ValidacaoException(MensagensEnum.QTD_PAR_NULL.descricao, "quantidadeParcelas")
        }
    }

    private fun validacaoQuantidadeParcelas(simulacaoCredito: SimulacaoCredito) {
        if (simulacaoCredito.quantidadeParcelas == null || simulacaoCredito.quantidadeParcelas!! <= 0) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(MensagensEnum.QTD_PAR_NAO_NUL.descricao))
            throw ValidacaoException(MensagensEnum.QTD_PAR_NAO_NUL.descricao, "quanditadeParcelas")
        } else if (simulacaoCredito.valorEmprestimo != null) {
            logger.error(ERRO_NEGOCIO.plus(" - ").plus(MensagensEnum.VLR_EMP_NAO_NUL.descricao))
            throw ValidacaoException(MensagensEnum.VLR_EMP_NAO_NUL.descricao, "valorEmprestimo")
        }
    }

    private fun calcularIdade(simulacaoCredito: SimulacaoCredito) {
        val idade = simulacaoCredito.dataNascimento.until(LocalDate.now()).years
        with(idade) {
            when {
                this <= 25 -> simulacaoCredito.taxaJurosAno = Constantes.TAXAJUROSATE25
                this in 26..40 -> simulacaoCredito.taxaJurosAno = Constantes.TAXAJUROSATE40
                this in 41..60 -> simulacaoCredito.taxaJurosAno = Constantes.TAXAJUROSATE60
                else -> simulacaoCredito.taxaJurosAno = Constantes.TAXAJUROSACIMA60
            }
        }
    }

    private fun calcularParcelaFixa(
        valorEmprestimo: BigDecimal,
        taxaJurosAnual: BigDecimal,
        quantidadeParcelas: Int
    ): BigDecimal {
        val precisao = MathContext(10, RoundingMode.HALF_EVEN)
        val taxaJurosMensal = taxaJurosAnual.divide(Constantes.ANO, precisao)
        val potencia = BigDecimal.ONE.add(taxaJurosMensal).pow(-quantidadeParcelas, precisao)
        return valorEmprestimo.multiply(taxaJurosMensal, precisao)
            .divide(BigDecimal.ONE.subtract(potencia, precisao), precisao)
    }
}