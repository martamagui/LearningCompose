package com.example.udemycoursedummyproject.theory.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyBasicSlider() {
    var state by rememberSaveable { mutableStateOf(0f) }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$state")
        Slider(value = state, onValueChange = { state = it })
    }
}

@Composable
fun AdvanceSlider() {
    var state by rememberSaveable { mutableStateOf(0f) }
    var completedValue by rememberSaveable { mutableStateOf("0") }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$completedValue")
        Slider(
            value = state,
            onValueChange = { state = it },
            onValueChangeFinished = { completedValue = "$state" },
            valueRange = 0f..10f,
            steps = 9,
            //Simpre hay que restar 2 a los steps, ya que el primero y último no cuenta
            enabled = true
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(
    name = "Preview slider rango",
    showBackground = true,
)
@Composable
fun MyRangeSlider() {
    //Da error con remember Saveable
    var currentRange by remember { mutableStateOf(0f..10f) }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
        RangeSlider(
            values = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = "Valor inferior ${currentRange.start}")
        Text(text = "Valor superior ${currentRange.endInclusive}")
    }

}