package com.csis4175.bookcycles.ui.screens.get_this_book

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.csis4175.bookcycles.ui.components.BookPreview
import com.csis4175.bookcycles.ui.components.InputButton
import com.csis4175.bookcycles.ui.components.InputLocation

@Composable
fun GetThisBookScreen(){

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

    val imgSrc = "https://picsum.photos/200?id=1"

    Column (
        Modifier
            .verticalScroll(rememberScrollState())
    ) {
        BookPreview(
            title = title,
            author = author,
            description = description,
            imgSrc = imgSrc
        )

        InputLocation(
            label = "LOCATION",
            modifier = Modifier
                .height(300.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "THIS BOOK IS AVAILABLE AT 5.00 PM TODAY",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(4.dp))

        InputButton(
            onClick = {},
            Modifier
                .align(Alignment.End)
        ) {
            Text("BOOK A VISIT")
        }
    }
}