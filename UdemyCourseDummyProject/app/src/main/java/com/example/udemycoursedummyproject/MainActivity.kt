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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemycoursedummyproject.theory.MyBox
import com.example.udemycoursedummyproject.theory.MySpacer
import com.example.udemycoursedummyproject.theory.components.MyOutLinedTextField
import com.example.udemycoursedummyproject.ui.CheckInfo
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

                }
            }
        }
    }
}

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


@Preview(
    name = "Preview nº1",
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    UdemyCourseDummyProjectTheme {
        MyRadioButtonListContainer()
    }
}