package com.example.udemycoursedummyproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemycoursedummyproject.theory.MyBox
import com.example.udemycoursedummyproject.theory.components.MyOutLinedTextField
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
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Esto es un ejemplo",
        alpha = 0.5f,
        modifier = Modifier
            .clip(
                CircleShape
                //RoundedCornerShape(20.dp)
            )
            .border(2.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Esto es un ejemplo",
        alpha = 0.5f
    )
}

@Preview(
    name = "Preview nº1",
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    UdemyCourseDummyProjectTheme {
        MyImageAdvance()
    }
}