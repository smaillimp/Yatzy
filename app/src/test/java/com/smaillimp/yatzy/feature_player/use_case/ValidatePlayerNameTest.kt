package com.smaillimp.yatzy.feature_player.use_case

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class TestPlayerNameValidation {
    @Test
    fun `validation fails for empty player name`() {
        val validationResult = ValidatePlayerName().execute("")
        assertFalse(
            "Validation on empty player name should not be successful.", validationResult.successful
        )
        assertEquals("Please provide a user name.", validationResult.errorMessage)
    }

    @Test
    fun `validation succeeds for valid player name`() {
        val validationResult = ValidatePlayerName().execute("Andy")
        assertTrue(
            "Validation for valid name has to be successful.", validationResult.successful
        )
        assertNull(
            (
                "`validation.errorMessage` should be null " +
                        "(actual: ${validationResult.errorMessage} with valid player name."
                ),
            validationResult.errorMessage
        )
    }
}
