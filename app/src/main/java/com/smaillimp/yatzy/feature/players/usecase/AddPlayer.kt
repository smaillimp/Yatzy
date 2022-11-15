package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.repository.PlayerRepositoryInterface
import com.smaillimp.yatzy.feature.players.model.Player

class AddPlayer(
    private val repository: PlayerRepositoryInterface
) {
    suspend operator fun invoke(player: Player) {
        repository.insertPlayer(player)
    }
}
