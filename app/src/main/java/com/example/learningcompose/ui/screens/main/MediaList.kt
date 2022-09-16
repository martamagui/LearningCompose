package com.example.learningcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.learningcompose.model.MediaItem
import com.example.learningcompose.model.getMedia

@ExperimentalFoundationApi
@Composable
fun MediaList(navController: NavHostController, modifier: Modifier) {
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
        cells = GridCells.Adaptive(dimensionResource(id = R.dimen.grid_cell)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaItem(
                item = item,
                modifier = Modifier.padding(
                    dimensionResource(id = R.dimen.padding_xsmall),
                ),
                navController = navController

            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaItem(
    navController: NavHostController,
    item: MediaItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.clickable {
            navController.navigate("detail/${item.id}")
        }
    ) {
        Thumb(item)
        Title(item)
    }
}

@Composable
fun Title(item: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .padding(dimensionResource(id = R.dimen.padding_large))
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun Thumb(item: MediaItem) {
    Box(
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.item_heigth))
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
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size)),
                tint = Color.White
            )
            //Ejemplo de carga de icono desde los recursos
            //Icon(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = )
        }
    }
}
