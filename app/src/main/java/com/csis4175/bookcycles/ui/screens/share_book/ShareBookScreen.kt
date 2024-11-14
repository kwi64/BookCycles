package com.csis4175.bookcycles.ui.screens.share_book

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.csis4175.bookcycles.ui.components.InputTextField

// Data class to represent a book
data class Book(val image: Bitmap?,
                val title: String,
                val description: String,
                val dailyVisitTime: String)

@Composable
fun ShareBookScreen(
    onShareThisBookButtonClicked: (Book) -> Unit
) {
    var bookImage by remember { mutableStateOf<Bitmap?>(null) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dailyVisitTime by remember { mutableStateOf("") }

    // Launcher for capturing an image from the camera
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        bookImage = bitmap
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text("Share a Book", style = MaterialTheme.typography.displayLarge)

        Spacer(modifier = Modifier.height(8.dp))

        // Image Capture Section
        Box(
            modifier = Modifier
                .size(200.dp)
                .clickable { launcher.launch(null) }, // Open camera when clicked
            contentAlignment = Alignment.Center
        ) {
            if (bookImage != null) {
                Image(bitmap = bookImage!!.asImageBitmap(), contentDescription = "Book Image",
                    modifier = Modifier.size(200.dp))
            } else {
                Icon(
                    imageVector = Icons.Filled.Camera,
                    contentDescription = "Camera Icon",
                    modifier = Modifier.size(200.dp) // Size the icon appropriately
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title Input Field
        InputTextField(
            label = "Title",
            value = title,
            onValueChange = { title = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Description Input Field
        InputTextField(
            label = "Description",
            value = description,
            onValueChange = { description = it },
            modifier = Modifier.height(120.dp) // Make it larger for multi-line input
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Daily Visit Time Input Field
        InputTextField(
            label = "Daily Visit Time To Get This Book",
            value = dailyVisitTime,
            onValueChange = { dailyVisitTime = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val book = Book(image = bookImage,
                title = title,
                description = description,
                dailyVisitTime = dailyVisitTime)
            onShareThisBookButtonClicked(book)
        }) {
            Text("Share This Book")
        }
    }
}