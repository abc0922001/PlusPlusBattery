package com.dijia1124.plusplusbattery.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.dijia1124.plusplusbattery.R

@Composable
fun BackIcon(navController: NavController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.arrow_back_24dp_1f1f1f_fill1_wght400_grad0_opsz24),
            contentDescription = "Back"
        )
    }
}