package com.smaillimp.yatzy.domain.use_case

class ValidateUserName {
    fun execute(userName: String): ValidationResult {
        if(userName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Please provide a user name."
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}