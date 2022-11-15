package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.repository.PlayerRepositoryInterface
import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow

class GetPlayers(
    private val repository: PlayerRepositoryInterface
) {
    operator fun invoke(): Flow<List<Player>> {
        return repository.getPlayers()
    }
}
