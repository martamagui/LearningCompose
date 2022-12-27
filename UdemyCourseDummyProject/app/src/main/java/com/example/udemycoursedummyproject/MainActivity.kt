package com.example.udemycoursedummyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemycoursedummyproject.ui.theme.UdemyCourseDummyProjectTheme
import java.util.*

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
    showSystemUi = true,
    //podemos ver el api level como queramos
    apiLevel = 29,
    device = Devices.PIXEL_4,
    /*Se puede indicar el idioma a mostrar
    locale = Locale.ENGLISH*/
)
@Composable
fun MySuperTextParent() {
    MySuperText("Aprendiendo con Aristides :)")
}

@Composable
fun MySuperText(name:String) {
    Text(name)
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UdemyCourseDummyProjectTheme {
        Greeting("Android")
    }
}