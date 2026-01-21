package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        // IMPORTANTE: Navega a la ruta con mayúscula definida en Routes.kt
        navController.navigate(Routes.Menu.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Asegúrate de que existe R.drawable.logotriviapp
            // Si no tienes logo aún, comenta estas líneas de Image
            Image(
                painter = painterResource(id = R.drawable.logotriviapp),
                contentDescription = "Logo",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Trivia App",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}