package com.example.udemycoursedummyproject.theory.components

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


@Composable
fun MySwitch() {
    var switchState by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = switchState,
        onCheckedChange = { switchState = !switchState },
        enabled = true,
        colors = SwitchDefaults.colors(

            checkedThumbColor = Color.Cyan,
            uncheckedThumbColor = Color.Magenta,

            uncheckedTrackAlpha = 0.8f,
            checkedTrackAlpha = 1f,
            uncheckedTrackColor = Color.Red,
            checkedTrackColor = Color.DarkGray,

            disabledCheckedThumbColor = Color.White,
            disabledUncheckedTrackColor = Color.White,
        )
    )
}