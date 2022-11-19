package com.smaillimp.yatzy.feature.players.domain.usecase

import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow

interface GetPlayersInterface {
    operator fun invoke(): Flow<List<Player>>
}
