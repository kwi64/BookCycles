package com.csis4175.bookcycles.ui.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RegisterScreen(
    onCompleteRegistrationButtonClicked: () -> Unit = {}
){
    Column {
        Text("Register")
        Button(onClick = onCompleteRegistrationButtonClicked ) {
            Text("COMPLETE REGISTRATION")
        }
    }
}