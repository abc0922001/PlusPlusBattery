package com.dijia1124.plusplusbattery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun CardGroup(
    modifier: Modifier = Modifier,
    content: List<@Composable () -> Unit>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        content.forEachIndexed { index, item ->
            Box(
                modifier = Modifier
                    .clip(getListItemShape(index, content.size))
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                item()
            }
        }
    }
}