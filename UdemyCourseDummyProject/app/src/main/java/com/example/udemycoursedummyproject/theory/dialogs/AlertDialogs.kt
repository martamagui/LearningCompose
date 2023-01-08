package com.example.udemycoursedummyproject.theory.dialogs

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyAlertDialogContainer() {
    var isShown by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { isShown = true }) {
            Text(text = "Mostrar diálogo")
        }

        MyAlertDialog(
            //show = isShown,
            show = false,
            onDismiss = { isShown = false },
            onConfirm = { Log.i("MyAlertDialog", "Confirmado") }
        )
        MyCustomDialog(show = isShown) { isShown = false }
    }
}

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (show) {
            AlertDialog(
                onDismissRequest = { /*Cuando se clica fuera*/onDismiss },
                title = { Text("Título") },
                text = { Text(text = "Descripción de diálogo") },
                confirmButton = {
                    TextButton(onClick = onConfirm) {
                        Text(text = "ConfirmButton")
                    }
                },
                dismissButton = {
                    TextButton(onClick = onDismiss) {
                        Text(text = "DismissButton")
                    }
                }
            )
        }
    }
}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            //Deja crear lo que queramos
            Dialog(
                onDismissRequest = { onDismiss() },
                properties = DialogProperties(
                    //Para forzar que no se pueda cerrar
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                )
            ) {
                Column(
                    Modifier
                        .background(Color.LightGray)
                        .padding(2.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "hola caracola 😊")
                }
            }
        }
    }
}