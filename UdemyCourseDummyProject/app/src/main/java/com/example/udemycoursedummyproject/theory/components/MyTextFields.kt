package com.example.udemycoursedummyproject.theory.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldAdvance(myText: String, onValueChange: (String) -> Unit) {

    TextField(
        value = myText,
        onValueChange = {
            if (it.contains("a")) {
                onValueChange(it.replace("a", ""))
            } else {
                onValueChange(it)
            }
        },
        label = { Text(text = "Introduce un tu nombre") }
    )
}

@Composable
fun MyOutLinedTextField(myText: String, onValueChange: (String) -> Unit) {

    OutlinedTextField(
        value = myText,
        onValueChange = { onValueChange(it) },
        label = { Text(text = "Introduce un tu nombre") },
        modifier = Modifier.padding(4.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Green
        )
    )
}

@Composable
fun MyTextField(myText: String, onValueChange: (String) -> Unit) {
    TextField(value = myText, onValueChange = { onValueChange(it) })
}