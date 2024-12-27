package com.evandro_alves.simulador_credito.exceptions.handle

import java.io.Serializable;
import java.time.Instant;

data class StandardError(
    val timestamp: Instant,
    val status: Int,
    val message: String,
    val path: String
): Serializable