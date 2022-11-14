package com.smaillimp.yatzy.feature.players.domain.usecase

import com.smaillimp.yatzy.feature.players.usecase.ValidationResult

interface ValidatePlayerNameInterface {
    operator fun invoke(playerName: String): ValidationResult
}
