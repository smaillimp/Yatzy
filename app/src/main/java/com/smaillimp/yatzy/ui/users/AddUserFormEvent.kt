package com.smaillimp.yatzy.ui.users

sealed class AddUserFormEvent {
    data class UserNameChanged(val userName: String) : AddUserFormEvent()

    object Submit: AddUserFormEvent()
}
