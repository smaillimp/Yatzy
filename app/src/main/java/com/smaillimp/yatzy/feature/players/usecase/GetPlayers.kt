package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.repository.PlayerRepositoryInterface
import com.smaillimp.yatzy.feature.players.domain.usecase.GetPlayersInterface
import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow

class GetPlayers(
    private val repository: PlayerRepositoryInterface
) : GetPlayersInterface {
    override operator fun invoke(): Flow<List<Player>> {
        return repository.getPlayers()
    }
}
