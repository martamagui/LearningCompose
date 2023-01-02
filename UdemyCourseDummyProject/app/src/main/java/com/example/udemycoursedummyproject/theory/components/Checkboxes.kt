package com.example.udemycoursedummyproject.theory.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.udemycoursedummyproject.ui.CheckInfo

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }

    Checkbox(
        checked = state, onCheckedChange = { state = !state },
        enabled = false,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Cyan,
            disabledColor = Color.Gray,
            checkmarkColor = Color.Green
        )
    )
}


@Composable
fun MyCheckBoxWithText(checkInfo: CheckInfo) {
    Row(
        Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = checkInfo.onCheckedChange
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun ManyCheckBoxContainer() {
    val myOptions = getOptions(titles = listOf("Pikachu", "Magikarp", "Gyarados"))

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        myOptions.forEach { option ->
            MyCheckBoxWithText(option)
        }
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    //Map recorre y devuelve
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }

        CheckInfo(
            title = it,
            //  Para que se actualice el estado
            //  es necesario pasar una función que actualice el estado
            //  de cada checkbox
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Indeterminate) }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

