package com.smaillimp.yatzy.feature.players.domain.usecase

import com.smaillimp.yatzy.feature.players.model.Player

interface AddPlayerInterface {
    suspend operator fun invoke(player: Player)
}
