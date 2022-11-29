package com.smaillimp.yatzy.feature.players.usecase

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ValidatePlayerNameTest {
    val validatePlayerName = ValidatePlayerName()
    @Test
    fun `validation fails for empty player name`() {
        val validationResult = validatePlayerName("")
        validationResult.successful shouldBe false
        validationResult.errorMessage shouldBe "Please provide a user name."
    }

    @Test
    fun `validation fails for too short player name`() {
        val validationResult = validatePlayerName("A")
        validationResult.successful shouldBe false
        validationResult.errorMessage shouldBe "Player name is too short."
    }

    @Test
    fun `validation fails for too long player name`() {
        val validationResult = validatePlayerName("ABCDEFGHIJKLMNÑO")
        validationResult.successful shouldBe false
        validationResult.errorMessage shouldBe "Player name is too long."
    }

    @Test
    fun `validation succeeds for valid player name`() {
        val validationResult = validatePlayerName("Andy")
        validationResult.successful shouldBe true
        validationResult.errorMessage shouldBe null
    }
}
