package com.dijia1124.plusplusbattery.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(title: String,
              navigationIcon: (@Composable () -> Unit)? = null,
              actions: @Composable RowScope.() -> Unit = {},
              isTopLevel: Boolean = false) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = if (isTopLevel) MaterialTheme.typography.headlineSmall else MaterialTheme.typography.titleMedium)
        },
        navigationIcon = {
            // only show the navigation icon if it's not null
            if (navigationIcon != null) {
                Box(Modifier.padding(horizontal = 8.dp)) {
                    navigationIcon()
                }
            }
        },
        actions = {
            Row(Modifier.padding(horizontal = 8.dp)) {
                actions()
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    )
}