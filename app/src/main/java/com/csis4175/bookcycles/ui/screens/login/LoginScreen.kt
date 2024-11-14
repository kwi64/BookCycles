package com.csis4175.bookcycles.ui.screens.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            Modifier
                .fillMaxWidth()
                .weight(0.6f)
        )
        Text(
            "Book Cycles",
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(Modifier.height(20.dp))


        InputTextField(
            label = "TELEPHONE",
            value = telephone,
            onValueChange = { telephone = it },
            modifier = Modifier.fillMaxWidth()
        )

        InputTextField(
            label = "PASSWORD",
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Row {
            InputButton(
                onClick = onRegisterButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text("REGISTER")
            }
            Spacer(modifier = Modifier.width(20.dp))
            InputButton(
                onClick = onLoginButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text("LOG IN")
            }
        }
        Spacer(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}