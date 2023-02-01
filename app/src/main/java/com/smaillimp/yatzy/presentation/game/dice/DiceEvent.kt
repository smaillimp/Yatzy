package com.smaillimp.yatzy.presentation.game.dice


sealed class DiceEvent {
    object RollDice : DiceEvent()
    object SelectDice : DiceEvent()
}