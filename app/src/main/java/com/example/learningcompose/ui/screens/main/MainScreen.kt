package com.example.learningcompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.learningcompose.MainTopAppBar
import com.example.learningcompose.MediaList

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = { MainTopAppBar() }
    ) { padding ->
        MediaList(modifier = Modifier.padding(padding))
    }
}