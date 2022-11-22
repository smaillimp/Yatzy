package com.smaillimp.yatzy.feature.players.usecase

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidatePlayerNameTest {
    @Test
    fun `validation fails for empty player name`() {
        val validationResult = ValidatePlayerName()("")
        assertFalse(
            "Validation on empty player name should not be successful.", validationResult.successful
        )
        assertEquals("Please provide a user name.", validationResult.errorMessage)
    }

    @Test
    fun `validation fails for too short player name`() {
        val validationResult = ValidatePlayerName()("A")
        assertFalse(
            "Validation on too short player name should not be successful.", validationResult.successful
        )
        assertEquals("Player name is too short.", validationResult.errorMessage)
    }

    @Test
    fun `validation fails for too long player name`() {
        val validationResult = ValidatePlayerName()("ABCDEFGHIJKLMNÑO")
        assertFalse(
            "Validation on too long player name should not be successful.", validationResult.successful
        )
        assertEquals("Player name is too long.", validationResult.errorMessage)
    }

    @Test
    fun `validation succeeds for valid player name`() {
        val validationResult = ValidatePlayerName()("Andy")
        assertTrue(
            "Validation for valid name has to be successful.", validationResult.successful
        )
        assertNull(
            "`validation.errorMessage` should be null with valid player name.",
            validationResult.errorMessage
        )
    }
}
