package com.example.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.learningcompose.ui.theme.LearningComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MediaItem()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningComposeTheme {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Greeting(
                "Android",
                modifier = Modifier
                    .background(Color.LightGray)
            )
            Greeting(
                "Androide",
                modifier = Modifier.background(Color.Yellow)
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaItem() {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(color = Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberImagePainter(
                    data = "https://media.istockphoto.com/photos/closeup-portrait-of-funny-ginger-cat-wearing-sunglasses-isolated-on-picture-id1188445864?k=20&m=1188445864&s=612x612&w=0&h=0vuJeOxJr8Lu3Q1VdT1z7t6HcM8Oj7EVJe3CexGnH_8=",
                    builder = {
                        //transformations(CircleCropTransformation()),
                        crossfade(true)
                    }
                ),
                contentDescription ="Cat with sun glasses",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)
        ) {
            Text(text = "Titulo",
            style = MaterialTheme.typography.headlineSmall)
        }
    }
}

//@Preview(widthDp = 350, heightDp = 500, showBackground = true)
@Composable
fun btnToLearnModifiers() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.hola),
            fontSize =22.sp,
            fontStyle= androidx.compose.ui.text.font.FontStyle.Italic,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily.Monospace ,
            letterSpacing = 5.sp,
            //textDecoration = TextDecoration.LineThrough,
            textAlign = TextAlign.Center,
            lineHeight = 2.em,
            /*maxLines = 3,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,*/
            //style = MaterialTheme.typography.bodyMedium,
            style = MaterialTheme.typography.bodyMedium.copy(
                shadow = Shadow(
                    offset = Offset(2f, 20f),
                    blurRadius = 2f,
                    color = Color.White.copy(alpha = 0.9f)
                )
            ),

            modifier = Modifier
                .clickable {
                    /*De esta forma es clicable la vista completa*/
                }
                .background(Color.Cyan)
                .border(2.dp, Color.Blue)
                .padding(horizontal = 16.dp, vertical = 8.dp)

        )
    }
}


@Preview
@Composable
fun MediaList(){
    //Equivalente a Rv en xml
    LazyColumn(){
        items( 100){
            MediaItem()
        }
    }
}