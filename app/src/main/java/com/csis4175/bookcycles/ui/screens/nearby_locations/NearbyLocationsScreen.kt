package com.csis4175.bookcycles.ui.screens.nearby_locations

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NearbyLocationsScreen(
    onLocationClicked: () -> Unit = {},
    onShareBookButtonClicked: () -> Unit = {},
    onMyBooksButtonClicked: () -> Unit = {}
){
    Column {
        Text("Nearby Book Locations")
        Button(onClick = onLocationClicked){
            Text("New Westminster")
        }
        Button(onClick = onShareBookButtonClicked) {
            Text("Share a book")
        }
        Button(onClick = onMyBooksButtonClicked) {
            Text("My books")
        }
    }
}