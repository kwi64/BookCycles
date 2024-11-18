package com.csis4175.bookcycles.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VisitorItem(
    id: Int = 0,
    name: String = "",
    telephone: String = "",
    visitAt: String = "",
    onDeleteClick: ((id: Int, name: String) -> Unit)? = null
) {

    var cardModifier: Modifier = Modifier
        .fillMaxWidth()

    cardModifier = if (onDeleteClick != null) {
        cardModifier
            .combinedClickable(
                onClick = {},
                onLongClick = {
                    onDeleteClick(id, name)
                }
            )
    } else cardModifier

    ElevatedCard(
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceBright
        ),
        modifier = cardModifier
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = telephone,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = visitAt,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
    Spacer(Modifier.height(12.dp))
}