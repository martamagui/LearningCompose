package com.example.learningcompose.ui.screens.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.learningcompose.R
import com.example.learningcompose.Thumb
import com.example.learningcompose.model.getMedia

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun DetailScreen(mediaId: Int) {
    val mediaItem = remember { getMedia().first() { it.id == mediaId } }
    Scaffold(
        topBar = {
            SmallTopAppBar(title = {
                Text(text = mediaItem.title)
            })
        }) {
        Thumb(
            item = mediaItem, Modifier.padding(
                PaddingValues(
                    dimensionResource(id = R.dimen.padding_xsmall)
                )
            )
        )
    }

}