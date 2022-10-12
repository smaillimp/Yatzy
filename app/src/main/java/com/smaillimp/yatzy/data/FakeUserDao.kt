package com.smaillimp.yatzy.data

import User
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeUserDao {
    private val userList = mutableListOf<User>()
    private val users = MutableLiveData<List<User>>()

    init {
        users.value = userList
    }

    fun addUser(user: User) {
        userList.add(user)
        users.value = userList
    }

    fun getUsers() = users as LiveData<List<User>>
}