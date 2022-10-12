package com.example.learningcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learningcompose.ui.LearningComposeContent
import com.example.learningcompose.ui.MainScreen
import com.example.learningcompose.ui.screens.detail.DetailScreen

@Composable
fun Navigation(){
    LearningComposeContent {
        //recuerda el navegador a pesar de que se refresque el estado
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                MainScreen(navController)
            }
            composable(
                //Si es opcional
                //route = "detail?mediaId{mediaId}",
                //Por defecto los argumentos son de tipo string
                route = "detail/{mediaId}",
                arguments = listOf(
                    //Forzamos que sea un entero
                    navArgument("mediaId") { type = NavType.IntType }
                )
            ) { navBackStackEntry ->
                //Recogemos los argumentos enviados
                val id = navBackStackEntry.arguments?.getInt("mediaId")
                //Requerimos que no sea un nulo
                //El segundo parámetro sería el mensaje de error que salte si lo fuera
                //requireNotNull(id, {"no puede ser nulo porque el elemento necesita el id"})
                requireNotNull(id)
                DetailScreen(mediaId = id)
            }
        }

    }
}