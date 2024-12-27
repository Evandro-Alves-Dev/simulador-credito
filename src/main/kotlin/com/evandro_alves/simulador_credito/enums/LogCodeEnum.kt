package com.evandro_alves.simulador_credito.enums

enum class LogCodeEnum(val codigo: String, val descricao: String) {
    ENTRADA("PDE", "Payloade de dados de entrada"),
    SAIDA("PDS", "Payloade de dados de saída"),
    LOGICA_NEGOCIO("PLN", "Processamento lógica de negócio"),
    ERRO_NEGOCIO("EEN", "Erro na excução do negocio")
}