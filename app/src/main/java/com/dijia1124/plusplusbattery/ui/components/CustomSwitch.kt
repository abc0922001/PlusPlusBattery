package com.dijia1124.plusplusbattery.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dijia1124.plusplusbattery.R

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        thumbContent = {
            if (checked) {
                Icon(
                    painter = painterResource(id = R.drawable.check_24dp_000000_fill1_wght400_grad0_opsz24),
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.close_24dp_000000_fill1_wght400_grad0_opsz24),
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewCustomSwitch() {
    CustomSwitch(checked = true, onCheckedChange = {})
}

@Preview
@Composable
fun PreviewCustomSwitchUnchecked() {
    CustomSwitch(checked = false, onCheckedChange = {})
}
