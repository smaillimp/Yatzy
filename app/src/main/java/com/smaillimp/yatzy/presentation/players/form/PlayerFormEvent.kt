package com.smaillimp.yatzy.presentation.players.form

import com.smaillimp.yatzy.feature.players.model.Player

sealed class PlayerFormEvent {
    object clearPlayerName : PlayerFormEvent()
    data class ChangePlayerName(val player: Player) : PlayerFormEvent()
    data class Submit(val player: Player) : PlayerFormEvent()
}
