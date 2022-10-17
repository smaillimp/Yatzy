package com.smaillimp.yatzy.ui.users

import User
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smaillimp.yatzy.data.UserRepository
import com.smaillimp.yatzy.domain.use_case.ValidateUserName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val userRepository: UserRepository,
    private val validateUserName: ValidateUserName = ValidateUserName()
) : ViewModel() {

    var state by mutableStateOf(AddUserFormState())
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun getUser() = userRepository.getUsers()
    fun addUser(user: User) = userRepository.addUser(user)

    fun onEvent(event: AddUserFormEvent) {
        when (event) {
            is AddUserFormEvent.UserNameChanged -> {
                state = state.copy(userName = event.userName)
            }
            is AddUserFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val userNameResult = validateUserName.execute(state.userName)

        val hasError = listOf(
            userNameResult
        ).any { !it.successful }

        if(hasError) {
            state = state.copy(
                userNameError = userNameResult.errorMessage,
            )
            return
        }
        this.addUser(User(state.userName))

        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}