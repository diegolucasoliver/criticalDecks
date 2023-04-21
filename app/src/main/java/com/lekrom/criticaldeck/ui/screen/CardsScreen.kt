package com.lekrom.criticaldeck.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.lekrom.criticaldeck.model.Deck
import com.lekrom.criticaldeck.routing.Screen
import com.lekrom.criticaldeck.ui.components.DeckCard
import com.lekrom.criticaldeck.ui.components.Deck
import com.lekrom.criticaldeck.ui.theme.deckTitle

@Composable
fun CardsScreen(navController: NavController, deck: Deck) {
    var effectType by remember {
        mutableStateOf("")
    }
    var dialogOpen by remember {
        mutableStateOf(false)
    }

    if (dialogOpen && effectType.isNotBlank()) {
        val shape = RoundedCornerShape(corner = CornerSize(12.dp))
        Dialog(
            onDismissRequest = { dialogOpen = false },
            properties = DialogProperties(
                dismissOnBackPress = true
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(shape)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = shape
                    )
            ) {
                DeckCard(card = deck.effects.filter { it.type == effectType }.random())
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            deck.effectsType.forEach { type ->
                Deck(title = type) {
                    effectType = type
                    dialogOpen = true
                }
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navController.navigate(Screen.Rules.withArg(deck.type))
            }
        ) {
            Text(
                text = "Regras",
                style = MaterialTheme.typography.deckTitle
            )
        }
    }
}
