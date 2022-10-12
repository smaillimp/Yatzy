package com.smaillimp.yatzy.utilities

import com.smaillimp.yatzy.data.FakeDatabase
import com.smaillimp.yatzy.data.UserRepository
import com.smaillimp.yatzy.ui.users.UsersViewModelFactory

object InjectorUtils {
    fun provideUsersViewModelFactory(): UsersViewModelFactory {
        val userRepository = UserRepository.getInstance(FakeDatabase.getInstance().userDao)
        return UsersViewModelFactory(userRepository)
    }
}