package com.dijia1124.plusplusbattery.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dijia1124.plusplusbattery.R
import com.dijia1124.plusplusbattery.ui.components.AppScaffold
import com.dijia1124.plusplusbattery.ui.components.BackIcon
import com.dijia1124.plusplusbattery.ui.components.getListItemShape
import com.dijia1124.plusplusbattery.vm.BatteryMonitorSettingsViewModel

@Composable
fun BatteryMonitorSettings(
    navController: NavController,
    batteryMonVM: BatteryMonitorSettingsViewModel,
    currentTitle: String,
) {
    AppScaffold(currentTitle,
        navigationIcon = { BackIcon(navController)
        },
    ) {
        BatteryMonitorSettingsContent(batteryMonVM)
    }
}
@Composable
fun BatteryMonitorSettingsContent(
    batteryMonVM: BatteryMonitorSettingsViewModel
) {
    val items      by batteryMonVM.availableEntries.collectAsState()
    val visibleSet by batteryMonVM.visibleEntries.collectAsState()
    val currentSelection = visibleSet.ifEmpty { items.toSet() }
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .padding(horizontal = 8.dp)
            .verticalScroll(scrollState)
    ) {
        Row (modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(stringResource(R.string.please_select_the_entries_you_want_to_show_in_the_battery_monitor))
        }
        Spacer(Modifier.height(8.dp))

        items.forEachIndexed { index, entry ->
            val checked = currentSelection.contains(entry)
            val onCheckedChange: (Boolean) -> Unit = { on ->
                val newSet = if (visibleSet.isEmpty()) {
                    val allSet = items.toSet()
                    if (on) allSet + entry else allSet - entry
                } else {
                    if (on) visibleSet + entry else visibleSet - entry
                }
                batteryMonVM.setVisibleEntries(newSet)
            }
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = getListItemShape(index, items.size),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCheckedChange(!checked) }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = onCheckedChange
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(text = stringResource(entry.titleRes))
                }
            }
            Spacer(Modifier.height(2.dp))
        }
        Spacer(Modifier.height(20.dp))

    }
}
