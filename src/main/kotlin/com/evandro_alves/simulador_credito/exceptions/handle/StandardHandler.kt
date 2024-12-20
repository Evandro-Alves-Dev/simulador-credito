package com.evandro_alves.simulador_credito.exceptions.handle

import com.evandro_alves.simulador_credito.exceptions.ErroNegocioException
import com.evandro_alves.simulador_credito.exceptions.ResourceNotFoundException
import com.evandro_alves.simulador_credito.exceptions.ValidacaoException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class StandardHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun atributoNaoEncontrado(e: ResourceNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val error = StandardError(
            timestamp = Instant.now(),
            status = HttpStatus.NOT_FOUND.value(),
            message = e.message ?: "Recurso não encontrarado '${e.campo}' ",
            path = request.requestURI
        )
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun atributoInvalido(e: HttpMessageNotReadableException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val error = StandardError(
            timestamp = Instant.now(),
            status = HttpStatus.BAD_REQUEST.value(),
            message = "Atributo inválido",
            path = request.requestURI
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }

    @ExceptionHandler(ValidacaoException::class)
    fun validacao(e: ValidacaoException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val error = StandardError(
            timestamp = Instant.now(),
            status = HttpStatus.BAD_REQUEST.value(),
            message = "Atributo inválido '${e.campo}'",
            path = request.requestURI
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }

    @ExceptionHandler(ErroNegocioException::class)
    fun validacao(e: ErroNegocioException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val error = StandardError(
            timestamp = Instant.now(),
            status = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            message = e.message ?: "Erro de negócio",
            path = request.requestURI
        )
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error)
    }
}