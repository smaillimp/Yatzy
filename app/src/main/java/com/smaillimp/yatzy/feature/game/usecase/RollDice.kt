package com.smaillimp.yatzy.feature.game.usecase

import com.smaillimp.yatzy.feature.game.model.Dice

class RollDice {
    operator fun invoke(dice: Dice) {
        dice.eyes = (1..6).random()
    }
}