package com.example.trivialapp_base.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavHostController, viewModel: GameViewModel) {
    val pregunta = viewModel.preguntaActual

    if (viewModel.juegoTerminado) {
        LaunchedEffect(Unit) {
            navController.navigate(Routes.Score.route) {
                popUpTo(Routes.Menu.route) { inclusive = false }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Puntos: ${viewModel.puntuacion}", fontSize = 20.sp)

        LinearProgressIndicator(
            progress = { viewModel.tiempoRestante / 100f },
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (pregunta != null) {
            Text(
                text = pregunta.pregunta,
                fontSize = 22.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            viewModel.respuestasMezcladas.forEach { res ->
                Button(
                    onClick = { viewModel.responder(res) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    Text(res)
                }
            }
        } else {
            CircularProgressIndicator()
        }
    }
}