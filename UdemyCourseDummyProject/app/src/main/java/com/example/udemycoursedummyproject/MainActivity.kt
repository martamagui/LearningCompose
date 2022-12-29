package com.example.udemycoursedummyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.udemycoursedummyproject.theory.MyBox
import com.example.udemycoursedummyproject.ui.theme.UdemyCourseDummyProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UdemyCourseDummyProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyBox("Android")
                }
            }
        }
    }
}

@Composable
fun MyStateExample() {
    //remember almacena el estado anterior de la vista al repintarse, pero no si se rota la pantalla
    //var counter = remember { mutableStateOf(0) }

    //Almacena el estado de la variable aunque se rote la pantalla
    var counter = rememberSaveable { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter.value += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter.value} veces")

    }
}

@Preview(
    name = "Preview nº1",
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    UdemyCourseDummyProjectTheme {
        MyStateExample()
    }
}