package com.example.trivialapp_base.model

// Definición de la clase de datos Pregunta según requisitos
data class Pregunta(
    val pregunta: String,
    val categoria: String,
    val dificultad: String, // "Facil", "Medio", "Dificil"
    val respuesta1: String,
    val respuesta2: String,
    val respuesta3: String,
    val respuesta4: String,
    val respuestaCorrecta: String // Debe coincidir con una de las anteriores
)

// Objeto para simular la base de datos local (Hardcoded)
object ProveedorPreguntas {
    fun obtenerPreguntas(): MutableList<Pregunta> {
        return mutableListOf(
            Pregunta("¿Capital de Francia?", "Geografía", "Facil", "Madrid", "París", "Berlin", "Roma", "París"),
            Pregunta("¿Fórmula del agua?", "Ciencia", "Facil", "H2O", "CO2", "O2", "H2O2", "H2O"),
            Pregunta("¿Quién pintó la Mona Lisa?", "Arte", "Medio", "Picasso", "Van Gogh", "Da Vinci", "Dalí", "Da Vinci"),
            Pregunta("¿Planeta más grande?", "Ciencia", "Medio", "Tierra", "Marte", "Júpiter", "Saturno", "Júpiter"),
            Pregunta("¿Año descubrimiento América?", "Historia", "Medio", "1492", "1500", "1485", "1992", "1492"),
            Pregunta("¿Elemento químico Au?", "Química", "Dificil", "Plata", "Oro", "Cobre", "Aluminio", "Oro"),
            Pregunta("¿Autor del Quijote?", "Literatura", "Facil", "Cervantes", "Quevedo", "Lope", "Góngora", "Cervantes"),
            Pregunta("¿Velocidad de la luz?", "Física", "Dificil", "300.000 km/s", "150.000 km/s", "1000 km/s", "Mach 1", "300.000 km/s"),
            Pregunta("¿Moneda de Japón?", "Economía", "Medio", "Yuan", "Won", "Yen", "Dólar", "Yen"),
            Pregunta("¿Que animal posee la mayor fuerza de mordida del reino animal y que ha sido medido?", "Animal", "Custom", "Cocodrilo de agua salada", "Tiburón blanco", "Orcas", "Tortuga caiman", "Cocodrilo de agua salada"),
            Pregunta("¿Rey de los dioses griegos?", "Mitología", "Facil", "Zeus", "Hades", "Poseidón", "Ares", "Zeus"),
            Pregunta("¿Hueso más largo del cuerpo?", "Anatomía", "Medio", "Fémur", "Tibia", "Húmero", "Radio", "Fémur"),
            Pregunta("¿Cuando comenzó la primera y segunda guerra mundial?", "Historia", "Custom,", "1915 y 1938", "1920 y 1945", "1918 y 1940", "1914 y 1939", "1914 y 1939"),
            Pregunta("¿Que caballo ganó en 2013 el Arima Kinen?", "Deporte", "Custom","Goldship", "Gentildonna", "Tosen Jordan", "Orfevre", "Orfevre"), // Patrocinado por Villodres
            Pregunta("¿Quien dijo la frase de 'Dios ha muerto, y nosotros lo hemos matado'?", "Filosofia", "Socrates", "Nietzsche", "Platón", "Franz Kafka", "Schopenhauer", "Nietzsche"),
            Pregunta("¿Que poeta escribió el verso de 'Maldigo a mis estrellas en amarga tristeza y desparpajo por haber hecho a mi amor tan alto y a mi tan bajo'?","Filosofia","Custom","William Blake","Shakespear","John Keats","Lord Byron", "William Blake"), // Patrocinado por Villodres
            Pregunta("¿Que animal es un cetáceo?", "Animal", "Custom", "Hipopótamo", "Cocodrilo", "Delfín", "Manta/Raya", "Delfín")
        )
    }
}