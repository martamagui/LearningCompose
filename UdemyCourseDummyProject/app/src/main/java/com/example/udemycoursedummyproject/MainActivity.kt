package com.example.udemycoursedummyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(
            text = "Ejemplo", modifier = Modifier
                .padding(20.dp)
        )
        Text(
            text = "Ejemplo", modifier = Modifier
                .padding(20.dp)
        )
        Text(
            text = "Ejemplo", modifier = Modifier
                .padding(20.dp)
        )
        Text(
            text = "Ejemplo", modifier = Modifier
                .padding(20.dp)
        )
        Text(
            text = "Ejemplo", modifier = Modifier
                .padding(20.dp)
        )
        Text(
            text = "Ejemplo", modifier = Modifier
                .padding(20.dp)
        )

    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            ),
        verticalArrangement = Arrangement.SpaceEvenly,

        ) {
        Text(
            text = "hola", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(300.dp)
        )
        Text(
            text = "hola", modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(300.dp)
        )
        Text(
            text = "hola", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(300.dp)
        )
        Text(
            text = "hola", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(300.dp)
        )
        Text(
            text = "hola", modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(30.dp)
        )
        Text(
            text = "hola", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(30.dp)
        )
        Text(
            text = "hola", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(30.dp)
        )
        Text(text = "hola", modifier = Modifier.background(Color.Magenta))
        Text(text = "hola", modifier = Modifier.background(Color.Green))
        /*  Text(text = "hola", modifier = Modifier.background(Color.Cyan).weight(3f))
            Text(text = "hola", modifier = Modifier.background(Color.Magenta).weight(1f))
            Text(text = "hola", modifier = Modifier.background(Color.Green).weight(1f))
        */
    }
}

@Composable
fun MyBox(name: String) {
    //Si aun box no se le asigna altura o anchura,
    // va a ocupar unicamente el espacio que necesite
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(70.dp)
                .height(50.dp)
                .background(Color.Cyan)
                //Para que haya scroll
                .verticalScroll(
                    rememberScrollState()
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Esto es un texto largo el cual se podrá scrollear en $name")
        }
    }
}

@Preview(
    name = "Preview nº1",
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    UdemyCourseDummyProjectTheme {
        // MyBox("Android")
        //MyColumn()
        MyRow()
    }
}