package com.smaillimp.yatzy.ui.users

import User
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smaillimp.yatzy.R
import com.smaillimp.yatzy.utilities.InjectorUtils


class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideUsersViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(UsersViewModel::class.java)

        val textView_users = findViewById(R.id.textView_users) as TextView
        val button_addUser = findViewById(R.id.button_addUser) as Button
        val InputField_userName = findViewById(R.id.InputField_userName) as EditText


        viewModel.getUser().observe(this, Observer { users ->
            val stringBuilder = StringBuilder()
            users.forEach{ user ->
                stringBuilder.append("$user\n\n")
            }
            textView_users.text = stringBuilder.toString()
        })

        button_addUser.setOnClickListener {
            val user = User(InputField_userName.text.toString())
            viewModel.addUser(user)
            InputField_userName.setText("")
        }
    }
}