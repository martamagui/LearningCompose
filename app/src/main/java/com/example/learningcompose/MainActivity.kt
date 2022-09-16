package com.example.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learningcompose.ui.LearningComposeContent
import com.example.learningcompose.ui.MainScreen
import com.example.learningcompose.ui.screens.detail.DetailScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeContent {
                //recuerda el navegador a pesar de que se refresque el estado
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(navController)
                    }
                    composable(
                        route = "detail/{mediaId}",
                        arguments = listOf(
                            navArgument("mediaId") { type = NavType.IntType }
                        )
                    ) { navBackStackEntry ->
                        val id = navBackStackEntry.arguments?.getInt("mediaId")
                        requireNotNull(id)
                        DetailScreen(mediaId = id)
                    }
                }

            }
        }
    }
}





