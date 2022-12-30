package com.example.udemycoursedummyproject.theory.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.udemycoursedummyproject.theory.MySpacer

@Composable
fun MyProgressBarAdvance() {
    var progresStatus by rememberSaveable { mutableStateOf(0f) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progresStatus)
        MySpacer(size = 12)
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { if (progresStatus < 1) progresStatus += 0.1f },
                enabled = progresStatus < 1
            ) {
                Text(text = "Incrementar")
            }
            Button(
                onClick = { if (progresStatus > 0) progresStatus -= 0.1f },
                enabled = progresStatus > 0
            ) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgressBar() {

    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Magenta,
                strokeWidth = 6.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Cyan,
                backgroundColor = Color.Blue
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Mostrar/ocultar")
        }
    }
}

