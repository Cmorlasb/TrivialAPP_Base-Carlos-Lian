package com.example.trivialapp_base.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun ResultScreen(navController: NavHostController, viewModel: GameViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("¡Juego Terminado!", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Text("Tu Puntuación Final", fontSize = 20.sp)
        Text(
            text = "${viewModel.puntuacion}",
            fontSize = 64.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            // Vuelve al menú y limpia la pila de navegación
            navController.navigate(Routes.Screen_menu.route) {
                popUpTo(Routes.Screen_menu.route) { inclusive = true }
            }
        }) {
            Text("VOLVER AL MENÚ")
        }
    }
}
