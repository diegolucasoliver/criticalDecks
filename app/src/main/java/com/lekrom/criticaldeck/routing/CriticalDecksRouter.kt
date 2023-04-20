package com.lekrom.criticaldeck.routing

import android.content.res.AssetManager
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lekrom.criticaldeck.criticalDecksFromJson
import com.lekrom.criticaldeck.deckFromJson
import com.lekrom.criticaldeck.getDeck
import com.lekrom.criticaldeck.getRules
import com.lekrom.criticaldeck.readAssetsFile
import com.lekrom.criticaldeck.rulesFromJson
import com.lekrom.criticaldeck.ui.screen.CardsScreen
import com.lekrom.criticaldeck.ui.screen.DecksScreen
import com.lekrom.criticaldeck.ui.screen.RulesScreen

sealed class Screen(val route: String) {
    object Decks : Screen("decks_screen")
    object Cards : Screen("cards_screen")
    object Rules : Screen("rules_screen")

    fun withArg(arg: String): String {
        return buildString {
            append(route)
            append("/$arg")
        }
    }
}

@Composable
fun Navigation(assetManager: AssetManager) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Decks.route) {

        composable(route = Screen.Decks.route) {
            DecksScreen(
                navController = navController,
                decks = assetManager.readAssetsFile("CriticalDecks.json").criticalDecksFromJson()
            )
        }
        composable(
            route = Screen.Cards.route + "/{deck}",
            arguments = listOf(
                navArgument("deck") {
                    type = NavType.StringType

                }
            )
        ) { entry ->
            val deck = entry.arguments?.getString("deck").getDeck()
            CardsScreen(
                navController = navController,
                deck = assetManager.readAssetsFile(deck).deckFromJson()
            )
        }
        composable(
            route = Screen.Rules.route + "/{rules}",
            arguments = listOf(
                navArgument("rules") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val rules = entry.arguments?.getString("rules").getRules()
            RulesScreen(rules = assetManager.readAssetsFile(rules).rulesFromJson())
        }
    }
}

