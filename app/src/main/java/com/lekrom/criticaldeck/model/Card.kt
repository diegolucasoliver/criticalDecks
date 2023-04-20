package com.lekrom.criticaldeck.model

data class Card(
    val type: String,
    val title: String,
    val effect: String?,
    val criticalEffect: String?
)
