package com.csis4175.bookcycles.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.csis4175.bookcycles.R
import com.csis4175.bookcycles.ui.theme.BookPreviewImageShape


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookItem(
    id: Int,
    title: String,
    author: String,
    imgSrc: String,
    onClick: (id: Int) -> Unit,
    onLongClick: ((id: Int, title: String) -> Unit)? = null,
) {
    val height = 108.dp

    var cardModifier: Modifier = Modifier
        .height(height)
        .fillMaxWidth()
//        .height(IntrinsicSize.Min)

    cardModifier = if (onLongClick != null) {
        cardModifier
            .combinedClickable(
                onClick = { onClick(1) },
                onLongClick = { onLongClick(id, title) }
            )
    } else {
        cardModifier.clickable(onClick = { onClick(id) })
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceBright,
        ),
        shape = MaterialTheme.shapes.extraSmall,
        modifier = cardModifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
//                    .align(Alignment.Top)
                    .padding(start = 12.dp, top = 8.dp, bottom = 8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = author,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Start
                )
            }

            Box(
                contentAlignment = Alignment.TopEnd,
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(imgSrc)
                        .crossfade(true).build(),
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_img),
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(height)
                        .clip(BookPreviewImageShape())
                )
            }
        }
    }
    Spacer(Modifier.height(16.dp))
}