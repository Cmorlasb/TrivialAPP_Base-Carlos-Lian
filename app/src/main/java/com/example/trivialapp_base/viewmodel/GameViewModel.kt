package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas

class GameViewModel : ViewModel() {
    private var preguntasPartida: List<Pregunta> = emptyList()

    var indicePreguntaActual by mutableIntStateOf(0)
    var preguntaActual by mutableStateOf<Pregunta?>(null)
    var respuestasMezcladas by mutableStateOf<List<String>>(emptyList())
    var puntuacion by mutableIntStateOf(0)
    var tiempoRestante by mutableFloatStateOf(100f)
    var juegoTerminado by mutableStateOf(false)

    // --- NUEVO: Variables para Categoría y Dificultad ---
    var dificultadSeleccionada by mutableStateOf("Facil")
    var categoriaSeleccionada by mutableStateOf("Todas")

    private var timer: CountDownTimer? = null
    private val TIEMPO_TOTAL = 10000L

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad
    }

    // --- NUEVO: Función simple para cambiar categoría ---
    fun setCategoria(categoria: String) {
        categoriaSeleccionada = categoria
    }


    fun iniciarJuego() {
        val todas = ProveedorPreguntas.obtenerPreguntas()

        // --- FILTRO: Comprueba Dificultad Y Categoría ---
        preguntasPartida = todas.filter { pregunta ->
            val coincideDificultad = pregunta.dificultad == dificultadSeleccionada
            // Si es "Todas", acepta cualquier cosa. Si no, debe coincidir la categoría.
            val coincideCategoria = if (categoriaSeleccionada == "Todas") true else pregunta.categoria == categoriaSeleccionada

            coincideDificultad && coincideCategoria
        }.shuffled()

        if (preguntasPartida.isNotEmpty()) {
            puntuacion = 0
            indicePreguntaActual = 0
            juegoTerminado = false
            cargarPregunta()
        } else {
            // Si no hay preguntas de ese tipo, terminamos el juego inmediatamente
            juegoTerminado = true
        }
    }

    private fun cargarPregunta() {
        if (indicePreguntaActual < 10 && indicePreguntaActual < preguntasPartida.size) {
            val p = preguntasPartida[indicePreguntaActual]
            preguntaActual = p
            respuestasMezcladas = listOf(p.respuesta1, p.respuesta2, p.respuesta3, p.respuesta4).shuffled()
            iniciarTimer()
        } else {
            // Si llegamos a 10 o se acabaron las preguntas, terminamos
            juegoTerminado = true
            timer?.cancel()
        }
    }

    fun responder(res: String) {
        timer?.cancel()
        if (res == preguntaActual?.respuestaCorrecta) {
            puntuacion += 10
        }
        avanzar()
    }

    private fun avanzar() {
        indicePreguntaActual++
        cargarPregunta()
    }

    private fun iniciarTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(TIEMPO_TOTAL, 100) {
            override fun onTick(ms: Long) {
                tiempoRestante = (ms.toFloat() / TIEMPO_TOTAL) * 100f
            }
            override fun onFinish() {
                avanzar()
            }
        }.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}