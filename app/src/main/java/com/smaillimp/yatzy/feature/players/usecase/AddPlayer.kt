package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.repository.PlayerRepositoryInterface
import com.smaillimp.yatzy.feature.players.domain.usecase.AddPlayerInterface
import com.smaillimp.yatzy.feature.players.model.Player

class AddPlayer(
    private val repository: PlayerRepositoryInterface
) : AddPlayerInterface {
    override suspend operator fun invoke(player: Player) {
        repository.insertPlayer(player)
    }
}
