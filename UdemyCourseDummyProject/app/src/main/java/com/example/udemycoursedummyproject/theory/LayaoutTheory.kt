package com.example.udemycoursedummyproject.theory

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemycoursedummyproject.ui.theme.UdemyCourseDummyProjectTheme

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


@Composable
fun MySpacer(size: Int){
    Spacer(modifier = Modifier.height(size.dp))
}

//HomeWork
@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        MySpacer(30)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}



/*
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
}*/
