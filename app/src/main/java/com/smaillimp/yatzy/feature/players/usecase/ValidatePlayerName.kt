package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.usecase.ValidatePlayerNameInterface

class ValidatePlayerName : ValidatePlayerNameInterface {
    override fun invoke(playerName: String): ValidationResult {
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
