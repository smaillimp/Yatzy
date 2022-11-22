package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.usecase.ValidatePlayerNameInterface

class ValidatePlayerName : ValidatePlayerNameInterface {
    override fun invoke(playerName: String): ValidationResult {
        return when {
            playerName.isBlank() -> {
                ValidationResult(
                    successful = false,
                    errorMessage = "Please provide a user name."
                )
            }
            playerName.length < 2 -> {
                ValidationResult(
                    successful = false,
                    errorMessage = "Player name is too short."
                )
            }
            playerName.length > 15 -> {
                ValidationResult(
                    successful = false,
                    errorMessage = "Player name is too long."
                )
            }
            else -> {
                ValidationResult(
                    successful = true
                )
            }
        }
    }
}
