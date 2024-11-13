package com.csis4175.bookcycles.ui.screens.available_books

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AvailableBooksScreen(
    onAvailableBookClicked: () -> Unit = {}
){
    Column {
        Button(onClick = onAvailableBookClicked) {
            Text("Ancient Egypt Book")
        }
    }
}