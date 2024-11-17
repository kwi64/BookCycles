package com.csis4175.bookcycles.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.csis4175.bookcycles.ui.BookCyclesScreen


@Composable
fun AppBarMenu(navController: NavHostController) {
    var showMenu by remember { mutableStateOf(false) }
    IconButton(onClick = {
        showMenu = true
    }) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = "Menu"
        )
    }
    DropdownMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
            .padding(horizontal = 12.dp),
    ) {
        Column {
            MenuButton(
                onClick = {
//                    navController.navigate(BookCyclesScreen.NearbyLocations.name) {
//                        popUpTo(navController.graph.startDestinationId) {
//                            inclusive = true
//                        }
//                    }

                    navController.popBackStack(
                        BookCyclesScreen.NearbyLocations.name,
                        inclusive = false
                    )
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Localized description"
                )
                Spacer(Modifier.width(12.dp))
                Text(text = "HOME")
            }
        }
    }
}