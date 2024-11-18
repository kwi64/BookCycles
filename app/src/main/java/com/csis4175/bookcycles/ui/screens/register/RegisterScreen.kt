package com.csis4175.bookcycles.ui.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.csis4175.bookcycles.ui.components.InputButton
import com.csis4175.bookcycles.ui.components.InputLocation
import com.csis4175.bookcycles.ui.components.InputTextField

@Composable
fun RegisterScreen(
    onCompleteRegistrationButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        InputTextField(
            label = "NAME",
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth()
        )

        InputTextField(
            label = "TELEPHONE",
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth()
        )

        InputTextField(
            label = "PASSWORD",
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth()
        )

        InputTextField(
            label = "RE-TYPE PASSWORD",
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth()
        )

        InputLocation(
            label = "SET YOUR LOCATION",
            modifier = Modifier
                .height(300.dp)
        )

        Row {
            InputButton(
                onClick = onCompleteRegistrationButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text("COMPLETE REGISTRATION")
            }
        }
    }
}