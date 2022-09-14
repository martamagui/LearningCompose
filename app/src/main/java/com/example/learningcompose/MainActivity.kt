package com.example.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.learningcompose.ui.LearningComposeContent
import com.example.learningcompose.ui.theme.LearningComposeTheme

@ExperimentalFoundationApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeContent{
                Scaffold(
                    topBar = { MainTopAppBar() }
                ) { padding ->
                    MediaList(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}





