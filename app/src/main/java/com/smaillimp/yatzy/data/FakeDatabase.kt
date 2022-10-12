package com.smaillimp.yatzy.data

class FakeDatabase private constructor() {

    var userDao = FakeUserDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}
