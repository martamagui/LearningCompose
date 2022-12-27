package com.example.udemycoursedummyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
                    Greeting("Android")
                }
            }
        }
    }
}

//Se puede poner atributos a las previews
@Preview(
    name = "Preview nº1",
    heightDp = 50,
    showBackground = true,
    //showSystemUi = true,
    //podemos ver el api level como queramos
    apiLevel = 29,
    //device = Devices.PIXEL_4,
    /*Se puede indicar el idioma a mostrar
    locale = Locale.ENGLISH*/
)
@Composable
fun MySuperTextParent() {
    MySuperText(
        myText = "Aprendiendo con Aristides :)",
        modifier = Modifier
            .height(50.dp)
            .border(1.dp, Color.Cyan)
            .padding(start = 20.dp)
    )
}

@Composable
fun MySuperText(
    myText: String,
    modifier: Modifier
) {
    Text(
        myText,
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UdemyCourseDummyProjectTheme {
        Greeting("Android")
    }
}