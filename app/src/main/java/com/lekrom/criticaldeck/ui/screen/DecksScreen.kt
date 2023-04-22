package com.lekrom.criticaldeck.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lekrom.criticaldeck.getDeckColor
import com.lekrom.criticaldeck.model.CriticalDecks
import com.lekrom.criticaldeck.routing.Screen
import com.lekrom.criticaldeck.ui.components.Deck
import com.lekrom.criticaldeck.ui.theme.DefaultDeckTheme

@Composable
fun DecksScreen(navController: NavController, decks: CriticalDecks) {
    DefaultDeckTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.secondary)
                .padding(horizontal = 32.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Critical Decks",
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .padding(bottom = 48.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            decks.decks.forEach {
                Deck(title = it, it.getDeckColor()) {
                    navController.navigate(Screen.Cards.withArg(it))
                }
            }
        }
    }
}