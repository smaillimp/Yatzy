package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.usecase.AddPlayerInterface
import com.smaillimp.yatzy.feature.players.model.Player

class AddPlayerMock : AddPlayerInterface {
    public var called: Boolean = false
    override suspend fun invoke(player: Player) {
        called = true
    }
}
