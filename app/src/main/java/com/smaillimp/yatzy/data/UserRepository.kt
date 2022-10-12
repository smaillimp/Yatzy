package com.smaillimp.yatzy.data

import User

class UserRepository private constructor(private val userDao: FakeUserDao){

    fun addUser(user: User) {
        userDao.addUser(user)
    }

    fun getUsers() = userDao.getUsers()

    companion object {
        @Volatile private var instance: UserRepository? = null

        fun getInstance(userDao: FakeUserDao) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userDao).also { instance = it }
            }
    }
}