package com.example.learningcompose

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.dp
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
        //cells = GridCells.Fixed(2), ,
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.grid_cell)),
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
    Card(
        modifier = modifier.clickable {
            navController.navigate("detail/${item.id}")
        },
        //elevation = 8.dp,
        elevation = 0.dp,
        border = BorderStroke(1.dp, Color.LightGray)
        //shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Thumb(
                item,
                Modifier.padding(PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)))
            )
            Title(item)
        }
    }

}

@Composable
fun Title(item: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.background(Color.Cyan)
            .padding(dimensionResource(id = R.dimen.padding_large))
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun Thumb(
    item: MediaItem,
    //Creamos en el constructor un param. modifier, que si no se pasa en la invocación del thum se inicializa como Modifier simple
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
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
