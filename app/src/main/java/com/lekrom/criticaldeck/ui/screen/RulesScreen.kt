package com.lekrom.criticaldeck.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lekrom.criticaldeck.model.Rules
import com.lekrom.criticaldeck.ui.components.ExpandableCard

@ExperimentalMaterialApi
@Composable
fun RulesScreen(rules: Rules) {

    Column(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        ExpandableCard(
            title = "Gerais",
            content = rules.description
        )

        ExpandableCard(
            title = "Especiais",
            listContent = rules.specials
        )

        ExpandableCard(
            title = "Variante Mortal",
            content = rules.mortalVariant
        )

        rules.proficiencyVariant?.let {
            ExpandableCard(
                title = "Variante por Proficiência",
                content = it
            )
        }

        rules.criticalSuccessDeckVariant?.let {
            ExpandableCard(
                title = "Variante com Baralho de Acertos Críticos",
                content = it
            )
        }
    }
}