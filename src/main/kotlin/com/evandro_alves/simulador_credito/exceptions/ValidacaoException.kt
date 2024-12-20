package com.evandro_alves.simulador_credito.exceptions

class ValidacaoException (msg: String, val campo:String) : RuntimeException(msg)