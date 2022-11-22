package com.smaillimp.yatzy.feature.players.usecase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidatePlayerNameTest {
    @Test
    fun `validation fails for empty player name`() {
        val validationResult = ValidatePlayerName()("")
        assertFalse(
            validationResult.successful,
            "Validation on empty player name should not be successful."
        )
        assertEquals("Please provide a user name.", validationResult.errorMessage)
    }

    @Test
    fun `validation fails for too short player name`() {
        val validationResult = ValidatePlayerName()("A")
        assertFalse(
            validationResult.successful,
            "Validation on too short player name should not be successful."
        )
        assertEquals("Player name is too short.", validationResult.errorMessage)
    }

    @Test
    fun `validation fails for too long player name`() {
        val validationResult = ValidatePlayerName()("ABCDEFGHIJKLMNÑO")
        assertFalse(
            validationResult.successful,
            "Validation on too long player name should not be successful."
        )
        assertEquals("Player name is too long.", validationResult.errorMessage)
    }

    @Test
    fun `validation succeeds for valid player name`() {
        val validationResult = ValidatePlayerName()("Andy")
        assertTrue(
            validationResult.successful,
            "Validation for valid name has to be successful."
        )
        assertNull(
            validationResult.errorMessage,
            "`validation.errorMessage` should be null with valid player name."
        )
    }
}
