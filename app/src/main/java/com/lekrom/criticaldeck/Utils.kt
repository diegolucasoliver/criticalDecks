package com.lekrom.criticaldeck

import android.content.res.AssetManager
import com.google.gson.Gson
import com.lekrom.criticaldeck.model.CriticalDecks
import com.lekrom.criticaldeck.model.Deck
import com.lekrom.criticaldeck.model.Rules

val gson = Gson()

fun String.deckFromJson(): Deck = gson.fromJson(this, Deck::class.java)

fun String.criticalDecksFromJson(): CriticalDecks = gson.fromJson(this, CriticalDecks::class.java)

fun String.rulesFromJson(): Rules = gson.fromJson(this, Rules::class.java)

fun AssetManager.readAssetsFile(fileName : String): String =
    open(fileName).bufferedReader().use{it.readText()}

fun String?.getDeck(): String = if (this == "Falha Crítica") "CriticalFlawDeck.json"
else "CriticalSuccessDeck.json"

fun String?.getRules(): String = if (this == "Falha Crítica") "CriticalFlawRules.json"
else "CriticalSuccessRules.json"

