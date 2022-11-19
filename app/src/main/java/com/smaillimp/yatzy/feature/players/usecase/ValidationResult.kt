package com.smaillimp.yatzy.feature.players.usecase

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null,
)
