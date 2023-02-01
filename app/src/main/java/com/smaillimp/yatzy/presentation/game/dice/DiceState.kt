package com.smaillimp.yatzy.presentation.game.dice

import com.smaillimp.yatzy.feature.game.model.Dice

data class DiceState(
    val dice: Dice = Dice(6),
    val eyes: Int = 6
)