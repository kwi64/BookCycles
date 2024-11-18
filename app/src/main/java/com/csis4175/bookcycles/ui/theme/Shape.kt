package com.csis4175.bookcycles.ui.theme

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class BookPreviewImageShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val height = size.height
        val width = size.width / 3

        val path = Path().apply {
            moveTo(x = width, 0f)
            lineTo(height, 0f)
            lineTo(height, height)
            lineTo(0f, height)
            close()
        }

        return Outline.Generic(path)
    }
}