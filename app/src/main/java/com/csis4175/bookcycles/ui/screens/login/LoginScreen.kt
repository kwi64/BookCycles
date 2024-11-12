package com.csis4175.bookcycles.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    onLoginButtonClicked: () -> Unit = {},
    onRegisterButtonClicked: () -> Unit = {},
){
    Column {
        Text("Login Screen")
        Button(onClick = onLoginButtonClicked) {
            Text("Login")
        }
        Button(onClick = onRegisterButtonClicked) {
            Text("Register")
        }
    }
}