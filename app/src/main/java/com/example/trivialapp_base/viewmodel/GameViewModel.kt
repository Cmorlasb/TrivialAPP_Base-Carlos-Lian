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
    var dificultadSeleccionada by mutableStateOf("Facil")

    private var timer: CountDownTimer? = null
    private val TIEMPO_TOTAL = 10000L // 10 segundos

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad
    }

    fun iniciarJuego() {
        // Obtenemos preguntas y filtramos. Asegúrate de que en ProveedorPreguntas
        // la dificultad esté escrita EXACTAMENTE igual ("Facil" o "Dificil").
        val todas = ProveedorPreguntas.obtenerPreguntas()
        preguntasPartida = todas.filter { it.dificultad == dificultadSeleccionada }.shuffled()

        if (preguntasPartida.isNotEmpty()) {
            puntuacion = 0
            indicePreguntaActual = 0
            juegoTerminado = false
            cargarPregunta()
        }
    }

    private fun cargarPregunta() {
        if (indicePreguntaActual < preguntasPartida.size) {
            val p = preguntasPartida[indicePreguntaActual]
            preguntaActual = p
            respuestasMezcladas = listOf(p.respuesta1, p.respuesta2, p.respuesta3, p.respuesta4).shuffled()
            iniciarTimer()
        } else {
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