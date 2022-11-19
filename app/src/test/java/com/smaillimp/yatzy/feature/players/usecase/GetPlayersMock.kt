package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.usecase.GetPlayersInterface
import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow

class GetPlayersMock : GetPlayersInterface {
    override fun invoke(): Flow<List<Player>> {
        TODO("Not yet implemented")
    }
}
