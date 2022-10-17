package com.smaillimp.yatzy.ui.users

import User
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
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

        val textView_users : TextView = findViewById(R.id.textView_users)
        val button_addUser : Button = findViewById(R.id.button_addUser)
        val editText_userName : EditText = findViewById(R.id.editText_userName)

        val state = viewModel.state

        editText_userName.doAfterTextChanged {
            viewModel.onEvent(AddUserFormEvent.UserNameChanged(editText_userName.text.toString()))
        }

        viewModel.getUser().observe(this, Observer { users ->
            val stringBuilder = StringBuilder()
            users.forEach{ user ->
                stringBuilder.append("$user\n\n")
            }
            textView_users.text = stringBuilder.toString()
        })

        button_addUser.setOnClickListener {
            viewModel.onEvent(AddUserFormEvent.Submit)
        }
    }
}