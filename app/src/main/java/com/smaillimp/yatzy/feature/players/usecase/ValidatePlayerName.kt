package com.smaillimp.yatzy.feature.players.usecase

class ValidatePlayerName {
    fun execute(playerName: String): ValidationResult {
        if (playerName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Please provide a user name."
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
