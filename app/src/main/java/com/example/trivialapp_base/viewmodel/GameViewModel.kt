package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas


class GameViewModel : ViewModel() {

    var indicePreguntaActual by mutableIntStateOf(0)
    var preguntaActual by mutableStateOf<Pregunta?>(null)
    var respuestasMezcladas by mutableStateOf<List<String>>(emptyList())
    var puntuacion by mutableIntStateOf(0)
    var tiempoRestante by mutableFloatStateOf(100f)
    var juegoTerminado by mutableStateOf(false)
    var dificultadSeleccionada by mutableStateOf("Facil")

    // Eliminamos 'dificultadSeleccionada' si la idea es siempre jugar el mix de 30 preguntas.
    // Si quisieras modos separados, habría que cambiar la lógica, pero para el mix 10-10-10:

    private var timer: CountDownTimer? = null
    private val TIEMPO_TOTAL = 10000L // 10 segundos

    // Inicializamos vacía, se llenará al iniciar juego
    private var preguntasPartida: List<Pregunta> = emptyList()

    fun iniciarJuego() {
        // CORRECCIÓN: Llamamos a la función que crea el mix de 30 preguntas (10 de cada)
        cargarPreguntasAleatorias()

        if (preguntasPartida.isNotEmpty()) {
            puntuacion = 0
            indicePreguntaActual = 0
            juegoTerminado = false
            cargarPregunta()
        }
    }

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad
    }

    // Esta función ahora es CRUCIAL: Genera la lista de 30 preguntas (10 Fáciles -> 10 Medias -> 10 Difíciles)
    private fun cargarPreguntasAleatorias() {
        val todas = ProveedorPreguntas.obtenerPreguntas()

        // Tomamos menos preguntas de cada tipo para sumar 10 en total
        val faciles = todas.filter { it.dificultad == "Facil" }.shuffled().take(4)
        val medias = todas.filter { it.dificultad == "Medio" }.shuffled().take(3)
        val dificiles = todas.filter { it.dificultad == "Dificil" }.shuffled().take(3)

        // Total = 10 preguntas mezcladas por dificultad progresiva
        preguntasPartida = faciles + medias + dificiles
    }

    private fun cargarPregunta() {
        // AÑADIDO: Verificamos que el índice sea menor que 10 Y menor que el tamaño de la lista
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
        /*if (indicePreguntaActual > 9) juegoTerminado
        else*/ indicePreguntaActual++
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