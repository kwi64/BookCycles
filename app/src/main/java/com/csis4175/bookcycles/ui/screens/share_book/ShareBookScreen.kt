package com.csis4175.bookcycles.ui.screens.share_book

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ShareBookScreen(
    onShareThisBookButtonClicked: () -> Unit = {}
){
    Column {
        Text("Share A BOOK")
        Button(onClick = onShareThisBookButtonClicked) {
            Text("Share This Book")
        }
    }
}