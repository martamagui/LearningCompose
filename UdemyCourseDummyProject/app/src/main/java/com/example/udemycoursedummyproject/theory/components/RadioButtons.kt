package com.example.udemycoursedummyproject.theory.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyRadioButton() {
    var status by rememberSaveable { mutableStateOf(true) }

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = status,
            onClick = { status = !status },
            //enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Yellow,
                unselectedColor = Color.LightGray,
                disabledColor = Color.Gray
            )
        )
        Text(text = "Ejemplo RButton")
    }
}

@Composable
fun MyRadioButtonListContainer() {
    var selectedRadioButton by rememberSaveable { mutableStateOf("Selected one") }
    MyRadioButtonList(
        selectedRadioButton = selectedRadioButton,
        onClick = { selectedRadioButton = it }
    )
}

@Composable
fun MyRadioButtonList(selectedRadioButton: String, onClick: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedRadioButton == "Selected one",
                onClick = { onClick("Selected one") })
            Text(text = "Selected one")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedRadioButton == "Sample",
                onClick = { onClick("Sample") })
            Text(text = "Sample")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedRadioButton == "Sample 2",
                onClick = { onClick("Sample 2") })
            Text(text = "Sample 2")
        }

    }
}

