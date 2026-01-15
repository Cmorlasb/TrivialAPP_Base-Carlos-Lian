package com.example.trivialapp_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp_base.ui.theme.TrivialAPP_BaseTheme
import com.example.trivialapp_base.view.GameScreen
import com.example.trivialapp_base.view.MenuScreen
import com.example.trivialapp_base.view.ResultScreen
import com.example.trivialapp_base.view.SplashScreen
import com.example.trivialapp_base.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrivialAPP_BaseTheme {
                // Controlador de navegación
                val gameViewModel: GameViewModel by viewModels()

                // Instanciamos el ViewModel una vez
                Navigation(gameViewModel)

                // Definición de rutas y navegación
            }
        }
    }
}
@Composable
fun Navigation(viewModel: GameViewModel){
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Routes.Screen_splash.route
    ) {
        composable(Routes.Screen_splash.route) { SplashScreen(navigationController) }
        composable(Routes.Screen_menu.route) { MenuScreen(navigationController, viewModel) }
        composable(Routes.Screen_game.route) { GameScreen(navigationController, viewModel) }
        composable(Routes.Screen_result.route) { ResultScreen(navigationController, viewModel) }
    }
}