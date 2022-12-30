package com.example.udemycoursedummyproject.theory.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButton() {

    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = {
                Log.i("My button", "CLICK!")
                enabled != enabled
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(2.dp, Color.Blue)
        ) {
            Column() {
                Text(text = "Hola")
            }
        }

        OutlinedButton(
            onClick = {
                Log.i("My button", "CLICK!")
                enabled != enabled
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Blue,
                disabledContentColor = Color.Magenta
            )
        ) {
            Text(text = "Botón delineado")
        }

        //Lo unico que lo diferencia es que no tendrá borde, pero lo puedes rellenar con lo que quieras
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Hola")
        }
    }
}