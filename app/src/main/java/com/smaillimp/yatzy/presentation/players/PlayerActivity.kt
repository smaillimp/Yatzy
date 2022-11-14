package com.smaillimp.yatzy.presentation.players

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smaillimp.yatzy.presentation.ui.theme.YatzyTheme
import com.smaillimp.yatzy.presentation.players.form.PlayerFormView
import com.smaillimp.yatzy.presentation.players.list.PlayersListView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            YatzyTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .padding(32.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        PlayerFormView()
                        PlayersListView()
                    }
                }
            }
        }
    }
}
