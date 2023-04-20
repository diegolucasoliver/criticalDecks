package com.lekrom.criticaldeck.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lekrom.criticaldeck.model.CriticalDecks
import com.lekrom.criticaldeck.routing.Screen
import com.lekrom.criticaldeck.ui.components.Deck

@Composable
fun DecksScreen(navController: NavController, decks: CriticalDecks) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        decks.decks.forEach {
            Deck(title = it) {
                navController.navigate(Screen.Cards.withArg(it))
            }
        }
    }
}