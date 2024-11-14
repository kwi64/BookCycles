package com.csis4175.bookcycles.ui.screens.nearby_locations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.csis4175.bookcycles.ui.components.InputButton
import com.csis4175.bookcycles.ui.components.InputMap

@Composable
fun NearbyLocationsScreen(
    onLocationClicked: () -> Unit = {},
    onShareBookButtonClicked: () -> Unit = {},
    onMyBooksButtonClicked: () -> Unit = {}
) {
    Column {

        InputMap(
            onLocationClicked = onLocationClicked,
            modifier = Modifier.weight(1f)
        )

        Row {
            InputButton(
                onClick = onShareBookButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text("SHARE A BOOK")
            }
            Spacer(modifier = Modifier.width(20.dp))
            InputButton(
                onClick = onMyBooksButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text("MY BOOKS")
            }
        }
    }
}