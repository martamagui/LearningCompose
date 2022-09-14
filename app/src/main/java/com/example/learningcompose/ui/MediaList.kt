package com.example.learningcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@ExperimentalFoundationApi
@Composable
fun MediaList(modifier: Modifier) {
    //Equivalente a Rv en xml
    /*LazyColumn(contentPadding = PaddingValues(4.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(getMedia()) { item ->
            MediaItem(item)
        }
    }*/
    /*LazyRow(contentPadding = PaddingValues(4.dp),
    horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        items(getMedia()) { item ->
            MediaItem(item)
        }
    }*/
    LazyVerticalGrid(
        //cells = GridCells.Fixed(2),
        cells = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(2.dp),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaItem(item, Modifier.padding(2.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(color = Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberImagePainter(
                    data = item.thumb,
                    builder = {
                        //transformations(CircleCropTransformation()),
                        crossfade(true)
                    }
                ),
                contentDescription = "Cat with sun glasses",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (item.type == MediaItem.Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    //size da las mismas dimensiones tanto al alto como al ancho
                    modifier = Modifier.size(92.dp),
                    tint = Color.White
                )
                //Ejemplo de carga de icono desde los recursos
                //Icon(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
