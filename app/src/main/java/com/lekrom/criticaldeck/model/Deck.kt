package com.lekrom.criticaldeck.model

class Deck(
    val type: String,
    val rules: Rules,
    val effectsType: List<String>,
    val effects: List<Card>
)
