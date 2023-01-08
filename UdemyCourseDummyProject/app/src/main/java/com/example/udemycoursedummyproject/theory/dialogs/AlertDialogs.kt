package com.example.udemycoursedummyproject.theory.dialogs

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
            show = isShown,
            onDismiss = { isShown = false },
            onConfirm = { Log.i("MyAlertDialog", "Confirmado") }
        )
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