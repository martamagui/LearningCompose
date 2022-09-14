package com.example.learningcompose

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun MainTopAppBar(){
   SmallTopAppBar(
       title = {
           Row(verticalAlignment = Alignment.CenterVertically) {
               Text(
                   text = stringResource(id = R.string.app_name)
               )
               Spacer(modifier = Modifier.padding(16.dp))
               Icon(Icons.Default.Person, contentDescription = "Person")
           }
       },
       actions = {
           AppBarAction(imageVector = Icons.Default.Search) {
               Log.d("Action", "hola")
           }
           AppBarAction(imageVector = Icons.Default.Share) {
               Log.d("Action", "hola")
           }
       }
       /*navigationIcon = {
           IconButton(onClick = { /*TODO*/ }) {
               Icon(
                   imageVector = Icons.Default.Menu,
                   contentDescription = "icon menu"
               )
           }
       }*/
   )
}

@Composable
fun AppBarAction(imageVector: ImageVector, onClick: () -> Unit){
    IconButton(onClick = onClick) {
        Icon(
            imageVector = imageVector,
            contentDescription = "search"
        )
    }
}