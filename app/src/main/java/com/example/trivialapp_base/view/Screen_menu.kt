package com.example.trivialapp_base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel
import com.google.android.gms.games.Game
import com.example.trivialapp_base.R


@Composable
fun MenuScreen(navController: NavHostController, viewModel: GameViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = "Logo Trivia",
            modifier = Modifier.size(400.dp)
        )

        Text(text = "Dificultad actual: ${viewModel.dificultadSeleccionada}")
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Button(onClick = { viewModel.setDificultad("Facil") }) { Text("Fácil") }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.setDificultad("Medio") }) { Text("Medio") }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.setDificultad("Dificil") }) { Text("Difícil") }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                viewModel.iniciarJuego() // Carga preguntas y resetea timer
                navController.navigate(Routes.Screen_game.route)
            },
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("JUGAR")
        }
    }
}
