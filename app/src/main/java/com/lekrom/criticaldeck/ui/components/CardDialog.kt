package com.lekrom.criticaldeck.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.lekrom.criticaldeck.model.Card

@Composable
fun CardDialog(card: Card, onDismissRequest: () -> Unit) {
    val shape = RoundedCornerShape(corner = CornerSize(12.dp))
    Dialog(
        onDismissRequest = { onDismissRequest() },
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
            DeckCard(card = card)
        }
    }
}