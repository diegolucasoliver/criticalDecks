package com.lekrom.criticaldeck.model

data class Rules(
    val description: String,
    val mortalVariant: String,
    val proficiencyVariant: String?,
    val criticalSuccessDeckVariant: String?,
    val specials: List<String>
)
