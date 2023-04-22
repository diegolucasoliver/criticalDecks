package com.lekrom.criticaldeck.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lekrom.criticaldeck.model.Rules
import com.lekrom.criticaldeck.ui.components.CustomTopAppBar
import com.lekrom.criticaldeck.ui.components.ExpandableCard
import com.lekrom.criticaldeck.ui.theme.CriticalDeckTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RulesScreen(navController: NavController, rules: Rules, isFlawTheme: Boolean) {

    CriticalDeckTheme(isFlawTheme) {
        Scaffold(
            topBar = {
                CustomTopAppBar(
                    title = { Text(text = "Regras") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                        }
                    },
                    backgroundColor = MaterialTheme.colors.primaryVariant
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .background(color = MaterialTheme.colors.secondary)
                    .padding(bottom = 16.dp, start = 32.dp, end = 32.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                val backgroundColor = MaterialTheme.colors.primary

                ExpandableCard(
                    title = "Gerais",
                    content = rules.description,
                    backgroundColor = backgroundColor
                )

                ExpandableCard(
                    title = "Especiais",
                    listContent = rules.specials,
                    backgroundColor = backgroundColor
                )

                ExpandableCard(
                    title = "Variante Mortal",
                    content = rules.mortalVariant,
                    backgroundColor = backgroundColor
                )

                rules.proficiencyVariant?.let {
                    ExpandableCard(
                        title = "Variante por Proficiência",
                        content = it,
                        backgroundColor = backgroundColor
                    )
                }

                rules.criticalSuccessDeckVariant?.let {
                    ExpandableCard(
                        title = "Variante com Baralho de Acertos Críticos",
                        content = it,
                        backgroundColor = backgroundColor
                    )
                }
            }
        }
    }
}