package com.lekrom.criticaldeck.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.lekrom.criticaldeck.model.Rules
import com.lekrom.criticaldeck.ui.theme.body
import com.lekrom.criticaldeck.ui.theme.boldBody
import com.lekrom.criticaldeck.ui.theme.cardTitle
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(rules: Rules) {
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetContent = {
            Column() {
                Text(
                    text = "Regras",
                    style = MaterialTheme.typography.cardTitle
                )
                Text(
                    text = rules.description,
                    style = MaterialTheme.typography.body
                )
                Text(
                    text = "Regras Especiais",
                    style = MaterialTheme.typography.boldBody
                )
                rules.specials.forEach {
                    Row {
                        Text(
                            text = "*",
                            style = MaterialTheme.typography.boldBody
                        )
                        Text(
                            text = it,
                            style = MaterialTheme.typography.body
                        )
                    }
                }
                Text(
                    text = "Variante Mortal",
                    style = MaterialTheme.typography.boldBody
                )
                Text(
                    text = rules.mortalVariant,
                    style = MaterialTheme.typography.body
                )
                rules.proficiencyVariant?.let {
                    Text(
                        text = "Variante por Proficiência",
                        style = MaterialTheme.typography.boldBody
                    )
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body
                    )
                }
                rules.criticalSuccessDeckVariant?.let {
                    Text(
                        text = "Variante com Baralho de Acertos Críticos",
                        style = MaterialTheme.typography.boldBody
                    )
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body
                    )
                }

                Button(
                    onClick = { coroutineScope.launch { modalSheetState.hide() } }
                ) {
                    Text(text = "Ok")
                }
            }
        }
    ) {}
}