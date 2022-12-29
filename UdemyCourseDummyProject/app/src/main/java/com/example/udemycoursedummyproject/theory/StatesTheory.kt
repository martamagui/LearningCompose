package com.example.udemycoursedummyproject.theory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyStateExample() {
    //remember almacena el estado anterior de la vista al repintarse, pero no si se rota la pantalla
    //var counter = remember { mutableStateOf(0) }

    //Almacena el estado de la variable aunque se rote la pantalla
    //var counter = rememberSaveable { mutableStateOf(0) }

    // Permite acceder directamente al value del estado necesita importar:
    /*import androidx.compose.runtime.getValue
     import androidx.compose.runtime.setValue*/
    var counter by rememberSaveable { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces")

    }
}
