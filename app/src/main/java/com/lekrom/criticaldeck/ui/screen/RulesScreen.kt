package com.lekrom.criticaldeck.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lekrom.criticaldeck.model.Rules
import com.lekrom.criticaldeck.ui.theme.body
import com.lekrom.criticaldeck.ui.theme.boldBody
import com.lekrom.criticaldeck.ui.theme.cardTitle

@Composable
fun RulesScreen(rules: Rules) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        Text(
            text = "Regras",
            style = MaterialTheme.typography.cardTitle,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = rules.description,
            style = MaterialTheme.typography.body
        )
        Text(
            text = "Regras Especiais",
            style = MaterialTheme.typography.boldBody,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 12.dp)
        )
        rules.specials.forEach {
            Row {
                Text(
                    text = "\u2022",
                    style = MaterialTheme.typography.boldBody,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = it,
                    style = MaterialTheme.typography.body
                )
            }
        }
        Text(
            text = "Variante Mortal",
            style = MaterialTheme.typography.boldBody,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 12.dp)
        )
        Text(
            text = rules.mortalVariant,
            style = MaterialTheme.typography.body
        )
        rules.proficiencyVariant?.let {
            Text(
                text = "Variante por Proficiência",
                style = MaterialTheme.typography.boldBody,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 12.dp)
            )
            Text(
                text = it,
                style = MaterialTheme.typography.body
            )
        }
        rules.criticalSuccessDeckVariant?.let {
            Text(
                text = "Variante com Baralho de Acertos Críticos",
                style = MaterialTheme.typography.boldBody,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 12.dp)
            )
            Text(
                text = it,
                style = MaterialTheme.typography.body
            )
        }
    }
}