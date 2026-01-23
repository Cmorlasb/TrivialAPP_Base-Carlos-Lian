package com.example.trivialapp_base.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavHostController, viewModel: GameViewModel) {
    val pregunta = viewModel.preguntaActual

    // Si el juego termina, navegamos al Score
    if (viewModel.juegoTerminado) {
        LaunchedEffect(Unit) {
            navController.navigate(Routes.Screen_result.route) {
                // Evita volver atrás a la pregunta
                popUpTo(Routes.Screen_menu.route) { inclusive = false }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Alineación Horizontal
        verticalArrangement = Arrangement.Center            // Disposición Vertical (CORREGIDO)
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
