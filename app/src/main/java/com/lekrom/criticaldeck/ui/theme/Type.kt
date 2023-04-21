package com.lekrom.criticaldeck.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val Typography.deckTitle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp,
            letterSpacing = 0.25.sp
        )
    }

val Typography.cardTitle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = 0.15.sp
        )
    }

val Typography.body: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp
        )
    }

val Typography.boldBody: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp
        )
    }