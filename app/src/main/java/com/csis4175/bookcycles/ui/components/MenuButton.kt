package com.csis4175.bookcycles.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun MenuButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    border: BorderStroke? = null,
    shape: Shape = RoundedCornerShape(6.dp),
    contentPadding: PaddingValues = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    val containerColor = if (enabled) colors.containerColor else colors.disabledContainerColor
    val contentColor = if (enabled) colors.contentColor else colors.disabledContentColor

    val mergedStyle = LocalTextStyle.current.merge(MaterialTheme.typography.labelLarge)

    Surface(
        modifier = Modifier
            .clickable { onClick() }
            .padding(vertical = 2.dp),
        border = border,
        shape = shape,
        color = containerColor,
        contentColor = containerColor,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides mergedStyle,
        ) {
            Row(
                modifier = modifier
                    .defaultMinSize(
                        minWidth = ButtonDefaults.MinWidth,
                        minHeight = 24.dp,
                    )
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}