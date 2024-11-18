package com.csis4175.bookcycles.ui.screens.visitors

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.csis4175.bookcycles.ui.components.BookPreview
import com.csis4175.bookcycles.ui.components.ConfirmActionDialog
import com.csis4175.bookcycles.ui.components.VisitorItem

@Composable
fun VisitorsScreen() {

    val visitors = listOf(1, 2, 3)

    val title = "Adventures of Huckleberry Finn"
    val author = "Mark Twain"
    val description = "The novel follows the journey of a young boy named " +
            "Huckleberry Finn and a runaway slave named Jim as they travel " +
            "down the Mississippi River on a raft. Set in the American " +
            "South before the Civil War, the story explores themes of " +
            "friendship, freedom, and the hypocrisy of society. " +
            "Through various adventures and encounters with a host of " +
            "colorful characters, Huck grapples with his personal values, " +
            "often clashing with the societal norms of the time."

    val imgSrc = "https://picsum.photos/200?id=2"


    val openDialog = remember { mutableStateOf(false) }
    val visitorName = remember { mutableStateOf("") }

    if (openDialog.value) {
        ConfirmActionDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            dialogText = "Are you sure you want to remove ${visitorName.value}'s visit?",
            dialogTitle = "Remove Visit?",
            onConfirmation = {
                openDialog.value = false
            }
        )
    }

    LazyColumn {
        item {
            BookPreview(
                title = title,
                author = author,
                description = description,
                imgSrc = imgSrc,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "SCHEDULED VISITORS",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(8.dp))
        }
        items(visitors) { id ->
            VisitorItem(
                id = id,
                name = "John Smith",
                telephone = "+1 124 456 7890",
                visitAt = "TODAY AT 5.00 PM",
                onDeleteClick = { id, name ->
                    visitorName.value = name
                    openDialog.value = true
                }
            )
        }
    }
}