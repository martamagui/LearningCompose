package com.example.udemycoursedummyproject.theory.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun MyIcon() {
    //Es parte de Material Design
    //Su tamaño por defecto sigue las guias de Matirial Desing
    //Los iconos se pueden encontrar en fonts.google.com/icons
    //Hay una librería extra de google que contiene todos los iconos de la web:
    //https://developer.android.com/jetpack/androidx/releases/compose-material?hl=es-419
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icono de estrella",
        tint = Color.Cyan
    )
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
