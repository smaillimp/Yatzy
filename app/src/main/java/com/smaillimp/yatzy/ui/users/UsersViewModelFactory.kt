package com.smaillimp.yatzy.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smaillimp.yatzy.data.UserRepository

class UsersViewModelFactory(private val userRepository: UserRepository): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UsersViewModel::class.java)){
            return  UsersViewModel(userRepository) as T
        }
        throw  java.lang.IllegalArgumentException ("UnknownViewModel")
    }
}