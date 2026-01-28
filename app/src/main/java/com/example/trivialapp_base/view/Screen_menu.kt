package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun MenuScreen(navController: NavHostController, viewModel: GameViewModel) {

    val colorFondoArriba = Color(0xFF6A1B9A)
    val colorFondoAbajo = Color(0xFFAB47BC)

    // Estado para controlar si el menú está desplegado
    var menuExpandido by remember { mutableStateOf(false) }

    // Lista de categorías manual para el desplegable
    val categorias = listOf("Todas", "Geografía", "Ciencia", "Historia", "General")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(colorFondoArriba, colorFondoAbajo))),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(300.dp).background(Color.LightGray.copy(alpha = 0.2f))
                )

                Spacer(modifier = Modifier.height(20.dp))

                // --- SECCIÓN DIFICULTAD ---
                Text("Dificultad:", fontSize = 16.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DificultadButton("Fácil", viewModel.dificultadSeleccionada == "Facil", { viewModel.setDificultad("Facil") }, Color(0xFF4CAF50))
                    DificultadButton("Medio", viewModel.dificultadSeleccionada == "Medio", { viewModel.setDificultad("Medio") }, Color(0xFFFF9800))
                    DificultadButton("Difícil", viewModel.dificultadSeleccionada == "Dificil", { viewModel.setDificultad("Dificil") }, Color(0xFFF44336))
                }

                Spacer(modifier = Modifier.height(20.dp))

                // --- SECCIÓN CATEGORÍA (DROPDOWN) ---
                Text("Categoría:", fontSize = 16.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    // Botón que abre el menú
                    Button(
                        onClick = { menuExpandido = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF3E5F5), // Color suave
                            contentColor = colorFondoArriba
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        // Texto de la categoría seleccionada
                        Text(
                            text = if (viewModel.categoriaSeleccionada == "Todas") "Todas las categorías" else viewModel.categoriaSeleccionada,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        // Usamos texto simple "▼" en lugar de Icon para evitar tus errores de compilación
                        Text("▼", fontSize = 12.sp)
                    }

                    // El Menú Desplegable
                    DropdownMenu(
                        expanded = menuExpandido,
                        onDismissRequest = { menuExpandido = false },
                        modifier = Modifier
                            .fillMaxWidth(0.7f) // Ancho del menú
                            .background(Color.White)
                    ) {
                        categorias.forEach { categoria ->
                            DropdownMenuItem(
                                text = { Text(text = categoria, color = Color.Black) },
                                onClick = {
                                    viewModel.setCategoria(categoria)
                                    menuExpandido = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // BOTÓN JUGAR
                Button(
                    onClick = {
                        viewModel.iniciarJuego()
                        navController.navigate(Routes.Screen_game.route)
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorFondoArriba),
                ) {
                    Text("JUGAR", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun DificultadButton(
    texto: String,
    seleccionado: Boolean,
    onClick: () -> Unit,
    colorActivo: Color
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (seleccionado) colorActivo else Color(0xFFF0F0F0),
            contentColor = if (seleccionado) Color.White else Color.Black
        ),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        modifier = Modifier.defaultMinSize(minWidth = 70.dp)
    ) {
        Text(text = texto, fontSize = 12.sp)
    }
}