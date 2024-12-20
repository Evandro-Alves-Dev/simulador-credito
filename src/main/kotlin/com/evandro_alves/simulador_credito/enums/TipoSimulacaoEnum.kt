package com.evandro_alves.simulador_credito.enums

enum class TipoSimulacaoEnum(codigo: String, descricao: String) {
    SVP("SVP","Simulação por valor parcela"),
    SDN("SDN","Simulação por data de nascimento"),
    SQP("SQP", "Simulação por quantidade de parcelas");
}