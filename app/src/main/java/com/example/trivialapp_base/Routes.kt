package com.example.trivialapp_base

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object Menu : Routes("menu")  // Ahora con Mayúscula inicial
    object Game : Routes("game")  // Ahora con Mayúscula inicial
    object Score : Routes("score") // Ahora con Mayúscula inicial
}