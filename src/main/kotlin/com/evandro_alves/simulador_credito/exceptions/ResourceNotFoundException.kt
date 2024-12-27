package com.evandro_alves.simulador_credito.exceptions


class ResourceNotFoundException(msg: String, val campo: String) : RuntimeException(msg)