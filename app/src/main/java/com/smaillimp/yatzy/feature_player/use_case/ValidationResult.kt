package com.smaillimp.yatzy.feature_player.use_case

data class ValidationResult (
    val successful: Boolean,
    val errorMessage: String? = null,
)
