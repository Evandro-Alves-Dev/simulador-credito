package com.evandro_alves.simulador_credito.controller

import com.evandro_alves.simulador_credito.dto.request.SimulacaoRequest
import com.evandro_alves.simulador_credito.dto.response.SimulacaoResponse
import com.evandro_alves.simulador_credito.controller.mapper.toSimulacoesResponse
import com.evandro_alves.simulador_credito.controller.mapper.toSimuladorCredito
import com.evandro_alves.simulador_credito.enums.LogCodeEnum
import com.evandro_alves.simulador_credito.enums.TipoSimulacaoEnum
import com.evandro_alves.simulador_credito.service.SimulacaoCreditoService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/simulador-credito/v1")
class SimulacaoCreditoController(
        private val simuladorCreditoService: SimulacaoCreditoService
) {
    private val logger = LoggerFactory.getLogger(SimulacaoCreditoController::class.java)

    companion object {
        private val LOG_ENTRADA = LogCodeEnum.ENTRADA.codigo
        private val LOG_SAIDA = LogCodeEnum.SAIDA.codigo
    }

    @PostMapping("/valor-parcela", produces = ["application/json"], consumes = ["application/json"])
    fun simularCreditoPorValorParcela(
            @Valid @RequestBody
            simulacaoRequest: SimulacaoRequest
    ): ResponseEntity<List<SimulacaoResponse>> {

        logger.info(LOG_ENTRADA.plus(" - ").plus("Iniciado simulação por valor parcela").plus(" - ").plus(simulacaoRequest))

        val simuladorCredito = simulacaoRequest.toSimuladorCredito(TipoSimulacaoEnum.SVP)

        val simulacaoRealizada = simuladorCreditoService.simularPorValorParcela(simuladorCredito)

        val simulacaoResponse = simulacaoRealizada.toSimulacoesResponse()

        logger.info(LOG_SAIDA.plus(" - ").plus("Finalizado simulação por valor parcela").plus(" - ").plus(simulacaoResponse))

        return ResponseEntity(simulacaoResponse, HttpStatus.OK)
    }

    @PostMapping("/data-nascimento", produces = ["application/json"], consumes = ["application/json"])
    fun simularCreditoPorDataNascimento(
            @Valid @RequestBody
            simulacaoRequest: SimulacaoRequest
    ): ResponseEntity<List<SimulacaoResponse>> {

        logger.info(LOG_ENTRADA.plus(" - ").plus("Iniciado simulação por data nascimento").plus(" - ").plus(simulacaoRequest))

        val simuladorCredito = simulacaoRequest.toSimuladorCredito(TipoSimulacaoEnum.SDN)

        val simulacaoRealizada = simuladorCreditoService.simularPorDataNascimento(simuladorCredito)

        val simulacaoResponse = simulacaoRealizada.toSimulacoesResponse()

        logger.info(LOG_SAIDA.plus(" - ").plus("Finalizado simulação por data nascimento").plus(" - ").plus(simulacaoResponse))

        return ResponseEntity(simulacaoResponse, HttpStatus.OK)
    }

    @PostMapping("/quantidade-parcela", produces = ["application/json"], consumes = ["application/json"])
    fun simularCreditoPorQuantidadeparcela(
            @Valid @RequestBody
            simulacaoRequest: SimulacaoRequest
    ): ResponseEntity<List<SimulacaoResponse>> {

        logger.info(LOG_ENTRADA.plus(" - ").plus("Iniciado simulação por quantidade parcela").plus(" - ").plus(simulacaoRequest))

        val simuladorCredito = simulacaoRequest.toSimuladorCredito(TipoSimulacaoEnum.SQP)

        val simulacaoRealizada = simuladorCreditoService.simularPorQuantidadeParcela(simuladorCredito)

        val simulacaoResponse = simulacaoRealizada.toSimulacoesResponse()

        logger.info(LOG_SAIDA.plus(" - ").plus("Finalizado simulação por quantidade parcela").plus(" - ").plus(simulacaoResponse))

        return ResponseEntity(simulacaoResponse, HttpStatus.OK)
    }
}