package com.example.udemycoursedummyproject.theory.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un texto", color = Color.Red)
        Text(text = "Esto es un texto", fontSize = 10.sp)
        Text(text = "Esto es un texto", fontWeight = FontWeight.Bold)
        Text(text = "Esto es un texto", fontWeight = FontWeight.Light)
        Text(text = "Esto es un texto", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un texto",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un texto",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un texto", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
    }
}