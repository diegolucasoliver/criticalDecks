package com.lekrom.criticaldeck.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lekrom.criticaldeck.model.Deck
import com.lekrom.criticaldeck.routing.Screen
import com.lekrom.criticaldeck.ui.components.CardDialog
import com.lekrom.criticaldeck.ui.components.CustomTopAppBar
import com.lekrom.criticaldeck.ui.components.Deck
import com.lekrom.criticaldeck.ui.theme.CriticalDeckTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CardsScreen(navController: NavController, deck: Deck) {
    var effectType by remember {
        mutableStateOf("")
    }
    var dialogOpen by remember {
        mutableStateOf(false)
    }
    val isFlawTheme = deck.type == "Falha Crítica"

    CriticalDeckTheme(isFlawTheme) {

        if (dialogOpen && effectType.isNotBlank()) {
            CardDialog(
                card = deck.effects.filter { it.type == effectType }.random(),
                MaterialTheme.colors.primary
            ) {
                dialogOpen = false
            }
        }

        Scaffold(
            topBar = {
                CustomTopAppBar(
                    title = { Text(text = deck.type) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                        }
                    },
                    actions = {
                        Text(
                            text = "REGRAS",
                            modifier = Modifier
                                .clickable { navController.navigate(Screen.Rules.withArg(deck.type)) }
                                .padding(end = 8.dp)
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primaryVariant
                )
            }
        ) {

            Column(
                modifier = Modifier
                    .background(color = MaterialTheme.colors.secondary)
                    .padding(horizontal = 32.dp, vertical = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Column {
                    deck.effectsType.forEach { type ->
                        Deck(title = type, MaterialTheme.colors.primary) {
                            effectType = type
                            dialogOpen = true
                        }
                    }
                }
            }

        }
    }
}
