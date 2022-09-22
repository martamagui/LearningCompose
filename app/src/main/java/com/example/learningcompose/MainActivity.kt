package com.example.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learningcompose.ui.LearningComposeContent
import com.example.learningcompose.ui.MainScreen
import com.example.learningcompose.ui.navigation.Navigation
import com.example.learningcompose.ui.screens.detail.DetailScreen
import com.example.learningcompose.ui.theme.LearningComposeTheme
import com.example.learningcompose.ui.theme.Shapes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           /* MaterialTheme(
                colorScheme = lightColorScheme(),
                typography = Typography(),
            ) { Navigation() }*/
            LearningComposeTheme {
                Navigation()
            }
        }
    }
}





