package com.lekrom.criticaldeck.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lekrom.criticaldeck.R
import com.lekrom.criticaldeck.model.Card
import com.lekrom.criticaldeck.ui.theme.CardBackground
import com.lekrom.criticaldeck.ui.theme.CriticalDeckTheme
import com.lekrom.criticaldeck.ui.theme.body
import com.lekrom.criticaldeck.ui.theme.boldBody
import com.lekrom.criticaldeck.ui.theme.cardTitle

@Composable
fun DeckCard(card: Card) {
    Box(
        modifier = Modifier
            .background(color = CardBackground)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = card.title,
                style = MaterialTheme.typography.cardTitle
            )
            card.effect?.let {
                Text(
                    text = card.effect,
                    style = MaterialTheme.typography.body
                )
            }
            card.criticalEffect?.let {
                Row {
                    Text(
                        text = stringResource(id = R.string.critical_effect),
                        style = MaterialTheme.typography.boldBody,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    CriticalDeckTheme() {
        DeckCard(
            Card(
                type = "",
                title = "Coisas demais!",
                effect = "Você fica emaranhado em seus equipamentos e fica sobrecarregado até gastar 2 ações de Interagir para se libertar.",
                criticalEffect = "Teste"
            )
        )
    }
}