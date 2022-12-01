package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.repository.PlayerRepositoryInterface
import com.smaillimp.yatzy.feature.players.domain.usecase.DeletePlayerInterface
import com.smaillimp.yatzy.feature.players.model.Player

class DeletePlayer(
    private val repository: PlayerRepositoryInterface
) : DeletePlayerInterface {
    override suspend operator fun invoke(player: Player) {
        repository.deletePlayer(player)
    }
}
