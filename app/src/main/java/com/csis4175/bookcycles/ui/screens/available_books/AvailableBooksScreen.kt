package com.csis4175.bookcycles.ui.screens.available_books

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.csis4175.bookcycles.ui.components.BookItem
import com.csis4175.bookcycles.ui.components.ConfirmActionDialog


@Composable
fun AvailableBooksScreen(
    onAvailableBookClicked: (id: Int) -> Unit = {}
) {
    val books = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    val openDialog = remember { mutableStateOf(false) }
    val bookTitle = remember { mutableStateOf("") }

    if (openDialog.value) {
        ConfirmActionDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            dialogText = "Are you sure you want to delete ${bookTitle.value}?",
            dialogTitle = "Delete Book",
            onConfirmation = {
                openDialog.value = false
            }
        )
    }

    LazyColumn {
        items(books) { id ->
            BookItem(
                id = id,
                title = "Adventures of Huckleberry Finn",
                author = "Mark Twain",
                imgSrc = "https://picsum.photos/200?id=$id",
                onClick = onAvailableBookClicked,
//                onLongClick = { id, title ->
//                    bookTitle.value = title
//                    openDialog.value = true
//                }
            )
        }
    }
}