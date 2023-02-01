package com.smaillimp.yatzy.feature.game.usecase

import com.smaillimp.yatzy.feature.game.model.Dice
import io.kotest.matchers.ints.shouldBeInRange
import org.junit.jupiter.api.Test

class RollDiceTest {
    val rollDice = RollDice()

    @Test
    fun `roll dice return number between 1 and 6`() {
        val dice = Dice(1)
        rollDice(dice)
        dice.eyes shouldBeInRange (1..6)
    }
}