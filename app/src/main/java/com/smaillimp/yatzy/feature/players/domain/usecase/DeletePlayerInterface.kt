package com.smaillimp.yatzy.feature.players.domain.usecase

import com.smaillimp.yatzy.feature.players.model.Player

interface DeletePlayerInterface {
    suspend operator fun invoke(player: Player)
}
