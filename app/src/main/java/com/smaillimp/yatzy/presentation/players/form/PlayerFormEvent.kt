package com.smaillimp.yatzy.presentation.players.form

import com.smaillimp.yatzy.feature_player.model.Player

sealed class PlayerFormEvent{
    data class ChangePlayerName(val player: Player): PlayerFormEvent()
    data class AddPlayer(val player: Player): PlayerFormEvent()
}
