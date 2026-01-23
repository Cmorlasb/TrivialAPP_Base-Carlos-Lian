package com.example.trivialapp_base.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            navController.navigate(Routes.Screen_result.route) {
                popUpTo(Routes.Screen_menu.route) { inclusive = false }
            }
        }
    }

    val progresoAnimado by animateFloatAsState(
        targetValue = viewModel.tiempoRestante / 100f,
        label = "ProgressAnimation"
    )

    val SoftBlue = Color(0xFFE3F2FD)
    val SoftPurple = Color(0xFFEDE7F6)
    val AccentColor = Color(0xFF7E57C2)
    val TimerColor = Color(0xFF26A69A)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(SoftBlue, SoftPurple)
                )
            )
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    shadowElevation = 4.dp,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "Puntos: ${viewModel.puntuacion}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = AccentColor,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
                    )
                }

                LinearProgressIndicator(
                    progress = { progresoAnimado },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp)
                        .clip(RoundedCornerShape(50)),
                    color = if (progresoAnimado < 0.3f) Color(0xFFEF5350) else TimerColor,
                    trackColor = Color.White.copy(alpha = 0.5f),
                )
            }

            if (pregunta != null) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Pregunta ${viewModel.indicePreguntaActual + 1}",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = pregunta.pregunta,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            lineHeight = 30.sp,
                            color = Color(0xFF37474F)
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    viewModel.respuestasMezcladas.forEach { res ->
                        Button(
                            onClick = { viewModel.responder(res) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = AccentColor
                            ),
                            shape = RoundedCornerShape(16.dp),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 4.dp,
                                pressedElevation = 1.dp
                            )
                        ) {
                            Text(
                                text = res,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                }

            } else {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = AccentColor)
                }
            }
        }
    }
}