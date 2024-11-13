package com.csis4175.bookcycles.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.csis4175.bookcycles.ui.components.InputButton
import com.csis4175.bookcycles.ui.components.InputTextField

@Composable
fun LoginScreen(
    onLoginButtonClicked: () -> Unit = {},
    onRegisterButtonClicked: () -> Unit = {},
) {
    var telephone by rememberSaveable { mutableStateOf("123 456 7896") }
    var password by rememberSaveable { mutableStateOf("123456") }

    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Book Cycles",
            style = MaterialTheme.typography.displayLarge
        )

        InputTextField(
            label = "TELEPHONE",
            value = telephone,
            onValueChange = { telephone = it },
        )

        InputTextField(
            label = "PASSWORD",
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Row{
            InputButton(
                onClick = onLoginButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text("REGISTER")
            }
            Spacer(modifier = Modifier.width(20.dp))
            InputButton(
                onClick = onRegisterButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text("LOG IN")
            }
        }
    }
}