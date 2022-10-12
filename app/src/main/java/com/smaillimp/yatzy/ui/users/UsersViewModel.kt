package com.smaillimp.yatzy.ui.users

import User
import androidx.lifecycle.ViewModel
import com.smaillimp.yatzy.data.UserRepository

class UsersViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun getUser() = userRepository.getUsers()
    fun addUser(user: User) = userRepository.addUser(user)
}