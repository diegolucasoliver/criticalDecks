package com.lekrom.criticaldeck.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lekrom.criticaldeck.ui.theme.CardBackground
import com.lekrom.criticaldeck.ui.theme.deckTitle

@Composable
fun Deck(title: String, action: () -> Unit) {
    val shape = RoundedCornerShape(corner = CornerSize(12.dp))
    Box(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .clip(shape)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = shape
            )
            .background(color = CardBackground)
            .fillMaxWidth()
            .clickable { action() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.deckTitle
            )
        }
    }
}

@Preview
@Composable
fun DeckPreview() {
    Deck("Magia") {}
}