package com.example.trivialapp_base

sealed class Routes(val route: String) {
    object Screen_splash:Routes("splash")
    object Screen_menu:Routes("menu")
    object Screen_game:Routes("game")
    object Screen_result:Routes("result")
}
