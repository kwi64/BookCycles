package com.csis4175.bookcycles.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.csis4175.bookcycles.R

@Composable
fun InputMap(
    onLocationClicked: () -> Unit,
    modifier: Modifier
){
    Column(modifier) {
        OutlinedCard(
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
            onClick = onLocationClicked,
            shape = RoundedCornerShape(6.dp),
            modifier = modifier
        ) {
            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = "Location",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}