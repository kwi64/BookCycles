package com.csis4175.bookcycles.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirst
import kotlin.math.roundToInt


@Composable
fun CenterAlignedAppBar(
    title: @Composable () -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    val actionsRow = @Composable {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            content = actions
        )
    }

    Layout(
        content = {
            Box(Modifier.layoutId("navigationIcon")) {
                CompositionLocalProvider(
                    content = navigationIcon
                )
            }
            Box(Modifier.layoutId("title")) {
                CompositionLocalProvider(
                    content = title
                )
            }
            Box(Modifier.layoutId("actionIcons")) {
                CompositionLocalProvider(
                    content = actionsRow
                )
            }
        },
        modifier = Modifier
            .height(50.dp)
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) { measurable, constraints ->

        val navigationIconPlaceable =
            measurable.fastFirst { it.layoutId == "navigationIcon" }
                .measure(constraints.copy(minWidth = 0))
        val actionIconsPlaceable =
            measurable.fastFirst { it.layoutId == "actionIcons" }
                .measure(constraints.copy(minWidth = 0))

        val maxTitleWidth = if (constraints.maxWidth == Constraints.Infinity) {
            constraints.maxWidth
        } else {
            (constraints.maxWidth - navigationIconPlaceable.width - actionIconsPlaceable.width)
                .coerceAtLeast(0)
        }
        val titlePlaceable =
            measurable.fastFirst { it.layoutId == "title" }
                .measure(constraints.copy(minWidth = 0, maxWidth = maxTitleWidth))

        val layoutHeight = constraints.maxHeight

        var baseX = (constraints.maxWidth - titlePlaceable.width) / 2
        if (baseX < navigationIconPlaceable.width) {
            baseX += (navigationIconPlaceable.width - baseX)
        } else if (baseX + titlePlaceable.width >
            constraints.maxWidth - actionIconsPlaceable.width
        ) {
            baseX += ((constraints.maxWidth - actionIconsPlaceable.width) -
                    (baseX + titlePlaceable.width))
        }

        layout(constraints.maxWidth, layoutHeight) {
            // Navigation icon
            navigationIconPlaceable.placeRelative(
                x = 0,
                y = (layoutHeight - navigationIconPlaceable.height) / 2
            )

            // Title
            titlePlaceable.placeRelative(
                x = baseX,
                y = (layoutHeight - titlePlaceable.height) / 2
            )

            // Action icons
            actionIconsPlaceable.placeRelative(
                x = constraints.maxWidth - actionIconsPlaceable.width,
                y = (layoutHeight - actionIconsPlaceable.height) / 2
            )
        }
    }
}