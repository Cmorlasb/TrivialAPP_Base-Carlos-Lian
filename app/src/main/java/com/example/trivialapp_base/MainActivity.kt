package com.example.trivialapp_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp_base.ui.theme.TrivialAPP_BaseTheme
import com.example.trivialapp_base.view.*
import com.example.trivialapp_base.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrivialAPP_BaseTheme {
                // 1. Crear controlador y ViewModel
                val navigationController = rememberNavController()
                val gameViewModel: GameViewModel by viewModels()

                // 2. NavHost. Fíjate que Routes.Menu ahora funciona porque actualizamos Routes.kt
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.Splash.route
                ) {
                    composable(Routes.Splash.route) {
                        SplashScreen(navigationController)
                    }

                    composable(Routes.Menu.route) {
                        MenuScreen(navigationController, gameViewModel)
                    }

                    composable(Routes.Game.route) {
                        GameScreen(navigationController, gameViewModel)
                    }

                    composable(Routes.Score.route) {
                        ResultScreen(navigationController, gameViewModel)
                    }
                }
            }
        }
    }
}