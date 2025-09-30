package com.dijia1124.plusplusbattery.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape

@Composable
fun getListItemShape(index: Int, size: Int): Shape {
    val mediumCorner = MaterialTheme.shapes.medium.topStart
    val extraSmallCorner = MaterialTheme.shapes.extraSmall.topStart

    return when {
        size == 1 -> MaterialTheme.shapes.medium
        index == 0 -> RoundedCornerShape(
            topStart = mediumCorner,
            topEnd = mediumCorner,
            bottomStart = extraSmallCorner,
            bottomEnd = extraSmallCorner
        )
        index == size - 1 -> RoundedCornerShape(
            topStart = extraSmallCorner,
            topEnd = extraSmallCorner,
            bottomStart = mediumCorner,
            bottomEnd = mediumCorner
        )
        else -> MaterialTheme.shapes.extraSmall
    }
}
