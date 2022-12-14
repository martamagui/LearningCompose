package com.example.udemycoursedummyproject.theory.dialogs

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.udemycoursedummyproject.R
import com.example.udemycoursedummyproject.theory.components.MyRadioButtonList

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
        MyCustomDialog(show = false) { isShown = false }
        MyAdvancedCustomDialog(false) { isShown = true }
        MyConfirmationDialog(isShown) { isShown = true }
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
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
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


@Composable
fun MyAdvancedCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (show) {
            Dialog(
                onDismissRequest = { onDismiss() },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                Column(
                    Modifier
                        .background(Color.White)
                        .padding(12.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(6.dp))
                ) {
                    MyTitleDialog("Set backup account", Modifier)
                    AccountItem(email = "mail@mail.com", drawable = R.drawable.pic_one)
                    AccountItem(email = "mail2@mail.com", drawable = R.drawable.pic_two)
                }
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable), contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email)
    }
}

@Composable
fun MyTitleDialog(title: String, modifier: Modifier) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier.padding(bottom = 12.dp)
    )
}


@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (show) {
            Dialog(
                onDismissRequest = { onDismiss() },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(
                        Modifier
                            .background(Color.White)
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        MyTitleDialog("Phone ringtone", Modifier)
                        Divider(Modifier.fillMaxWidth(), Color.LightGray)
                        var status by rememberSaveable { mutableStateOf("") }
                        MyRadioButtonList(selectedRadioButton = status, onClick = { status = it })
                        Divider(Modifier.fillMaxWidth(), Color.LightGray)
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Cancel")
                            }
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Ok")
                            }
                        }

                    }
                }

            }
        }
    }
}