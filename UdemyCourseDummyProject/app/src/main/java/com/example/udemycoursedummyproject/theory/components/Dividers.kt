package com.example.udemycoursedummyproject.theory.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(){
    Divider(Modifier.padding(12.dp), color = Color.Cyan)
}