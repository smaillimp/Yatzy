package com.smaillimp.yatzy.feature_player.use_case

import junit.framework.Assert.assertEquals
import org.junit.Test

class TestPlayerNameValidation {
    @Test
    fun `validation fails for empty player name`() {
        val validationResult = ValidatePlayerName().execute("")
        assert(
            !validationResult.successful,
            { "Validation on empty player name should not be successful." }
        )
        assertEquals("Please provide a user name.", validationResult.errorMessage)
    }
}
