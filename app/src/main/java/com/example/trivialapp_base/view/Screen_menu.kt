package com.example.trivialapp_base.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun MenuScreen(navController: NavHostController, viewModel: GameViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TRIVIAL APP", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Dificultad actual: ${viewModel.dificultadSeleccionada}")
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Button(onClick = { viewModel.setDificultad("Facil") }) { Text("Fácil") }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.setDificultad("Dificil") }) { Text("Difícil") }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                viewModel.iniciarJuego() // Carga preguntas y resetea timer
                navController.navigate(Routes.Game.route)
            },
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("JUGAR")
        }
    }
}