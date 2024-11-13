package com.csis4175.bookcycles.ui.screens.my_books

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MyBooksScreen(
    onMyBookClicked: () -> Unit = {}
){
    Column {
        Button (
            onClick = onMyBookClicked
        ){
            Text("Ancient Egypt Book")
        }
    }
}