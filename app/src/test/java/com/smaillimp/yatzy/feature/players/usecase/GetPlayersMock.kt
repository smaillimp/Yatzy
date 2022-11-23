package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.usecase.GetPlayersInterface
import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPlayersMock : GetPlayersInterface {
    public var called = false
    override fun invoke(): Flow<List<Player>> {
        called = true
        return flow { listOf(Player(name = "Smaillim")) }
    }
}
