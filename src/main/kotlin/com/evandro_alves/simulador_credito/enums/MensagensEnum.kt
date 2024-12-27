package com.evandro_alves.simulador_credito.enums

enum class MensagensEnum(val descricao:String) {

    INI_PRO("Iniciado processamento"),
    FIM_PRO("Finalizado processamento"),
    VLR_EMP_NAO_NUL("Valor empréstimo não deve ser informado"),
    VLR_EMP_NUL("Valor empréstimo não informado ou menor que 0"),
    QTD_PAR_NAO_NUL("Quantidade de parcelas deve ser informada e deve ser maior que 0"),
    QTD_PAR_NULL("Quantidade de parcelas não deve ser informada")

}