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
            // ======================================================
            // CATEGORÍA: GEOGRAFÍA (30 Preguntas)
            // ======================================================

            // --- Geografía: FÁCIL (10) ---
            Pregunta("¿Capital de Francia?", "Geografía", "Facil", "Madrid", "París", "Berlin", "Roma", "París"),
            Pregunta("¿Capital de España?", "Geografía", "Facil", "Barcelona", "Sevilla", "Madrid", "Valencia", "Madrid"),
            Pregunta("¿Continente de Egipto?", "Geografía", "Facil", "Europa", "Asia", "África", "América", "África"),
            Pregunta("¿País de la Torre Eiffel?", "Geografía", "Facil", "Italia", "Francia", "Alemania", "Inglaterra", "Francia"),
            Pregunta("¿Capital de Italia?", "Geografía", "Facil", "Venecia", "Milán", "Roma", "Nápoles", "Roma"),
            Pregunta("¿País donde se comen tacos?", "Geografía", "Facil", "España", "Perú", "México", "Chile", "México"),
            Pregunta("¿Océano más grande?", "Geografía", "Facil", "Atlántico", "Índico", "Pacífico", "Ártico", "Pacífico"),
            Pregunta("¿Capital de Inglaterra?", "Geografía", "Facil", "Mánchester", "Liverpool", "Londres", "Dublín", "Londres"),
            Pregunta("¿Forma de la Tierra?", "Geografía", "Facil", "Plana", "Cuadrada", "Esférica", "Triangular", "Esférica"),
            Pregunta("¿Dónde está la Estatua de la Libertad?", "Geografía", "Facil", "París", "Londres", "Nueva York", "Toronto", "Nueva York"),

            // --- Geografía: MEDIO (10) ---
            Pregunta("¿Capital de Alemania?", "Geografía", "Medio", "Múnich", "Berlín", "Hamburgo", "Frankfurt", "Berlín"),
            Pregunta("¿Cuántos continentes hay (modelo 5)?", "Geografía", "Medio", "4", "5", "6", "7", "5"),
            Pregunta("¿País con forma de bota?", "Geografía", "Medio", "España", "Grecia", "Italia", "Portugal", "Italia"),
            Pregunta("¿Río más largo del mundo?", "Geografía", "Medio", "Nilo", "Amazonas", "Misisipi", "Yangtsé", "Amazonas"),
            Pregunta("¿Capital de Australia?", "Geografía", "Medio", "Sídney", "Melbourne", "Canberra", "Perth", "Canberra"),
            Pregunta("¿País más grande del mundo?", "Geografía", "Medio", "China", "EEUU", "Canadá", "Rusia", "Rusia"),
            Pregunta("¿Capital de Canadá?", "Geografía", "Medio", "Toronto", "Vancouver", "Ottawa", "Montreal", "Ottawa"),
            Pregunta("¿Desierto más grande del mundo?", "Geografía", "Medio", "Gobi", "Sahara", "Atacama", "Kalahari", "Sahara"),
            Pregunta("¿Dónde está Machu Picchu?", "Geografía", "Medio", "Bolivia", "México", "Perú", "Chile", "Perú"),
            Pregunta("¿Capital de China?", "Geografía", "Medio", "Shanghái", "Pekín", "Hong Kong", "Wuhan", "Pekín"),

            // --- Geografía: DIFÍCIL (10) ---
            Pregunta("¿Capital de Kazajistán?", "Geografía", "Dificil", "Almaty", "Astaná", "Taskent", "Biskek", "Astaná"),
            Pregunta("¿Montaña más alta de África?", "Geografía", "Dificil", "Everest", "K2", "Kilimanjaro", "Aconcagua", "Kilimanjaro"),
            Pregunta("¿Capital de Turquía?", "Geografía", "Dificil", "Estambul", "Ankara", "Esmirna", "Antalya", "Ankara"),
            Pregunta("¿Isla más grande del Mediterráneo?", "Geografía", "Dificil", "Cerdeña", "Córcega", "Sicilia", "Creta", "Sicilia"),
            Pregunta("¿País con más islas del mundo?", "Geografía", "Dificil", "Filipinas", "Indonesia", "Suecia", "Canadá", "Suecia"),
            Pregunta("¿Capital de Nueva Zelanda?", "Geografía", "Dificil", "Auckland", "Wellington", "Christchurch", "Sídney", "Wellington"),
            Pregunta("¿Estrecho entre España y África?", "Geografía", "Dificil", "Bósforo", "Gibraltar", "Ormuz", "Magallanes", "Gibraltar"),
            Pregunta("¿Dónde está el lago Titicaca?", "Geografía", "Dificil", "Chile/Perú", "Bolivia/Perú", "Brasil", "Ecuador", "Bolivia/Perú"),
            Pregunta("¿Fosa marina más profunda?", "Geografía", "Dificil", "Atacama", "Java", "Las Marianas", "Tonga", "Las Marianas"),
            Pregunta("¿Capital de Islandia?", "Geografía", "Dificil", "Oslo", "Helsinki", "Reikiavik", "Dublín", "Reikiavik"),


            // ======================================================
            // CATEGORÍA: CIENCIA (30 Preguntas)
            // ======================================================

            // --- Ciencia: FÁCIL (10) ---
            Pregunta("¿Fórmula del agua?", "Ciencia", "Facil", "H2O", "CO2", "O2", "H2O2", "H2O"),
            Pregunta("¿Animal que ladra?", "Ciencia", "Facil", "Gato", "Perro", "Vaca", "Pájaro", "Perro"),
            Pregunta("¿Planeta donde vivimos?", "Ciencia", "Facil", "Marte", "Venus", "Tierra", "Luna", "Tierra"),
            Pregunta("¿Cuántas patas tiene una araña?", "Ciencia", "Facil", "6", "8", "4", "10", "8"),
            Pregunta("¿Rey de la selva?", "Ciencia", "Facil", "Tigre", "Elefante", "León", "Mono", "León"),
            Pregunta("¿Líquido vital para la vida?", "Ciencia", "Facil", "Aceite", "Agua", "Leche", "Zumo", "Agua"),
            Pregunta("¿Símbolo químico del Oxígeno?", "Ciencia", "Facil", "Ox", "O", "Oi", "On", "O"),
            Pregunta("¿Satélite natural de la Tierra?", "Ciencia", "Facil", "Sol", "Marte", "Luna", "Estrella", "Luna"),
            Pregunta("¿Mejor amigo del hombre?", "Ciencia", "Facil", "Gato", "Caballo", "Perro", "Loro", "Perro"),
            Pregunta("¿Sentido para escuchar?", "Ciencia", "Facil", "Vista", "Olfato", "Gusto", "Oído", "Oído"),

            // --- Ciencia: MEDIO (10) ---
            Pregunta("¿Planeta más grande del sistema solar?", "Ciencia", "Medio", "Tierra", "Marte", "Júpiter", "Saturno", "Júpiter"),
            Pregunta("¿Hueso más largo del cuerpo?", "Ciencia", "Medio", "Fémur", "Tibia", "Húmero", "Radio", "Fémur"),
            Pregunta("¿Elemento químico Fe?", "Ciencia", "Medio", "Fósforo", "Flúor", "Hierro", "Francio", "Hierro"),
            Pregunta("¿Gas más abundante en la atmósfera?", "Ciencia", "Medio", "Oxígeno", "Nitrógeno", "Hidrógeno", "Helio", "Nitrógeno"),
            Pregunta("¿Animal terrestre más rápido?", "Ciencia", "Medio", "León", "Gacela", "Guepardo", "Caballo", "Guepardo"),
            Pregunta("¿Qué estudia la micología?", "Ciencia", "Medio", "Minerales", "Hongos", "Músculos", "Estrellas", "Hongos"),
            Pregunta("¿Cuántos corazones tiene un pulpo?", "Ciencia", "Medio", "1", "2", "3", "4", "3"),
            Pregunta("¿Metal líquido a temperatura ambiente?", "Ciencia", "Medio", "Plomo", "Mercurio", "Estaño", "Zinc", "Mercurio"),
            Pregunta("¿Central energética de la célula?", "Ciencia", "Medio", "Núcleo", "Mitocondria", "Ribosoma", "Vacuola", "Mitocondria"),
            Pregunta("¿Nombre del dedo gordo del pie?", "Ciencia", "Medio", "Índice", "Meñique", "Hallux", "Carpo", "Hallux"),

            // --- Ciencia: DIFÍCIL (10) ---
            Pregunta("¿Elemento químico Au?", "Ciencia", "Dificil", "Plata", "Oro", "Cobre", "Aluminio", "Oro"),
            Pregunta("¿Velocidad de la luz?", "Ciencia", "Dificil", "300.000 km/s", "150.000 km/s", "1000 km/s", "Mach 1", "300.000 km/s"),
            Pregunta("¿Quién descubrió la penicilina?", "Ciencia", "Dificil", "Pasteur", "Fleming", "Curie", "Darwin", "Fleming"),
            Pregunta("¿Número atómico del Carbono?", "Ciencia", "Dificil", "6", "12", "14", "8", "6"),
            Pregunta("¿Quién formuló la Teoría de la Relatividad?", "Ciencia", "Dificil", "Newton", "Einstein", "Hawking", "Bohr", "Einstein"),
            Pregunta("¿Cuántos huesos tiene el cuerpo humano adulto?", "Ciencia", "Dificil", "200", "206", "210", "212", "206"),
            Pregunta("¿Satélite más grande de Saturno?", "Ciencia", "Dificil", "Europa", "Titán", "Ío", "Ganimedes", "Titán"),
            Pregunta("¿Quién escribió 'El origen de las especies'?", "Ciencia", "Dificil", "Lamarck", "Darwin", "Mendel", "Wallace", "Darwin"),
            Pregunta("¿Unidad de frecuencia?", "Ciencia", "Dificil", "Watt", "Julio", "Hertz", "Voltio", "Hertz"),
            Pregunta("¿Gas noble más ligero?", "Ciencia", "Dificil", "Neón", "Argón", "Helio", "Xenón", "Helio"),


            // ======================================================
            // CATEGORÍA: HISTORIA Y CULTURA (30 Preguntas)
            // ======================================================

            // --- Historia: FÁCIL (10) ---
            Pregunta("¿País de las Pirámides?", "Historia", "Facil", "Grecia", "México", "Egipto", "China", "Egipto"),
            Pregunta("¿Transporte de los piratas?", "Historia", "Facil", "Coche", "Avión", "Barco", "Tren", "Barco"),
            Pregunta("¿Arma de un gladiador?", "Historia", "Facil", "Pistola", "Espada", "Láser", "Bomba", "Espada"),
            Pregunta("¿Quién descubrió América (oficialmente)?", "Historia", "Facil", "Magallanes", "Colón", "Cortés", "Pizarro", "Colón"),
            Pregunta("¿Vivienda de un rey medieval?", "Historia", "Facil", "Cueva", "Castillo", "Piso", "Choza", "Castillo"),
            Pregunta("¿Idioma de la Antigua Roma?", "Historia", "Facil", "Inglés", "Italiano", "Latín", "Griego", "Latín"),
            Pregunta("¿Guerreros japoneses antiguos?", "Historia", "Facil", "Ninjas", "Samuráis", "Vikingos", "Caballeros", "Samuráis"),
            Pregunta("¿Casco con cuernos (mito)?", "Historia", "Facil", "Romanos", "Griegos", "Vikingos", "Egipcios", "Vikingos"),
            Pregunta("¿Primer material usado por el hombre?", "Historia", "Facil", "Plástico", "Hierro", "Piedra", "Bronce", "Piedra"),
            Pregunta("¿Monstruo vendado de Egipto?", "Historia", "Facil", "Vampiro", "Momia", "Zombi", "Fantasma", "Momia"),

            // --- Historia: MEDIO (10) ---
            Pregunta("¿Quién pintó la Mona Lisa?", "Historia", "Medio", "Picasso", "Van Gogh", "Da Vinci", "Dalí", "Da Vinci"),
            Pregunta("¿Año descubrimiento América?", "Historia", "Medio", "1492", "1500", "1485", "1992", "1492"),
            Pregunta("¿Autor de Harry Potter?", "Historia", "Medio", "Tolkien", "J.K. Rowling", "G.R.R. Martin", "Stephen King", "J.K. Rowling"),
            Pregunta("¿Cervantes o Shakespeare murió antes?", "Historia", "Medio", "Cervantes", "Shakespeare", "Mismo día (aprox)", "Ninguno", "Mismo día (aprox)"),
            Pregunta("¿Primer hombre en la Luna?", "Historia", "Medio", "Yuri Gagarin", "Buzz Aldrin", "Neil Armstrong", "Michael Collins", "Neil Armstrong"),
            Pregunta("¿Pintor de 'La noche estrellada'?", "Historia", "Medio", "Monet", "Manet", "Van Gogh", "Picasso", "Van Gogh"),
            Pregunta("¿Siglo de la Revolución Francesa?", "Historia", "Medio", "XVII", "XVIII", "XIX", "XX", "XVIII"),
            Pregunta("¿Emperador francés derrotado en Waterloo?", "Historia", "Medio", "Luis XIV", "Carlomagno", "Napoleón", "Robespierre", "Napoleón"),
            Pregunta("¿Compositor sordo famoso?", "Historia", "Medio", "Bach", "Mozart", "Beethoven", "Chopin", "Beethoven"),
            Pregunta("¿Banda de John Lennon?", "Historia", "Medio", "Queen", "Rolling Stones", "The Beatles", "ABBA", "The Beatles"),

            // --- Historia: DIFÍCIL (10) ---
            Pregunta("¿Año caída Muro de Berlín?", "Historia", "Dificil", "1987", "1989", "1991", "1993", "1989"),
            Pregunta("¿Autor de 'Cien años de soledad'?", "Historia", "Dificil", "Vargas Llosa", "Cortázar", "García Márquez", "Borges", "García Márquez"),
            Pregunta("¿Guerra de los Cien Años duró...?", "Historia", "Dificil", "100 años", "116 años", "99 años", "101 años", "116 años"),
            Pregunta("¿Primer presidente de EEUU?", "Historia", "Dificil", "Lincoln", "Jefferson", "Washington", "Franklin", "Washington"),
            Pregunta("¿Filósofo del mito de la caverna?", "Historia", "Dificil", "Sócrates", "Aristóteles", "Platón", "Descartes", "Platón"),
            Pregunta("¿Año inicio Primera Guerra Mundial?", "Historia", "Dificil", "1912", "1914", "1918", "1939", "1914"),
            Pregunta("¿Autor de 'La Divina Comedia'?", "Historia", "Dificil", "Dante", "Petrarca", "Boccaccio", "Maquiavelo", "Dante"),
            Pregunta("¿Año llegada hombre a la Luna?", "Historia", "Dificil", "1965", "1969", "1971", "1959", "1969"),
            Pregunta("¿Pintor de 'Las Meninas'?", "Historia", "Dificil", "Goya", "El Greco", "Velázquez", "Murillo", "Velázquez"),
            Pregunta("¿País origen del café?", "Historia", "Dificil", "Colombia", "Brasil", "Etiopía", "Vietnam", "Etiopía"),


            // ======================================================
            // CATEGORÍA: GENERAL Y VARIOS (30 Preguntas)
            // ======================================================

            // --- General: FÁCIL (10) ---
            Pregunta("¿Cuántos días tiene una semana?", "General", "Facil", "5", "6", "7", "8", "7"),
            Pregunta("¿Resultado de 2 + 2?", "General", "Facil", "3", "4", "5", "22", "4"),
            Pregunta("¿Estación más calurosa?", "General", "Facil", "Invierno", "Otoño", "Primavera", "Verano", "Verano"),
            Pregunta("¿Instrumento con teclas blancas y negras?", "General", "Facil", "Guitarra", "Violín", "Piano", "Flauta", "Piano"),
            Pregunta("¿Opuesto de 'Blanco'?", "General", "Facil", "Rojo", "Azul", "Negro", "Verde", "Negro"),
            Pregunta("¿Moneda de Estados Unidos?", "General", "Facil", "Euro", "Dólar", "Peso", "Libra", "Dólar"),
            Pregunta("¿Fruta prohibida de Adán y Eva?", "General", "Facil", "Pera", "Plátano", "Manzana", "Uva", "Manzana"),
            Pregunta("¿Deporte de Messi?", "General", "Facil", "Tenis", "Fútbol", "Baloncesto", "Golf", "Fútbol"),
            Pregunta("¿Cuántos minutos tiene una hora?", "General", "Facil", "30", "60", "90", "100", "60"),
            Pregunta("¿Personaje principal de Mario Bros?", "General", "Facil", "Luigi", "Peach", "Mario", "Bowser", "Mario"),

            // --- General: MEDIO (10) ---
            Pregunta("¿Moneda de Japón?", "General", "Medio", "Yuan", "Won", "Yen", "Dólar", "Yen"),
            Pregunta("¿Diosa griega de la sabiduría?", "General", "Medio", "Venus", "Atenea", "Hera", "Afrodita", "Atenea"),
            Pregunta("¿Ganador Mundial Fútbol 2014?", "General", "Medio", "Argentina", "Brasil", "Alemania", "España", "Alemania"),
            Pregunta("¿Cuántas teclas tiene un piano estándar?", "General", "Medio", "66", "77", "88", "99", "88"),
            Pregunta("¿Fundador de Microsoft?", "General", "Medio", "Steve Jobs", "Bill Gates", "Elon Musk", "Mark Zuckerberg", "Bill Gates"),
            Pregunta("¿Libro sagrado del Islam?", "General", "Medio", "Biblia", "Torá", "Corán", "Vedas", "Corán"),
            Pregunta("¿Director de 'Jurassic Park'?", "General", "Medio", "Lucas", "Spielberg", "Cameron", "Nolan", "Spielberg"),
            Pregunta("¿Cuántos jugadores hay en un equipo de voleibol?", "General", "Medio", "5", "6", "7", "11", "6"),
            Pregunta("¿Ciudad de Batman?", "General", "Medio", "Metrópolis", "Gotham", "Nueva York", "Chicago", "Gotham"),
            Pregunta("¿Cuántos jugadores tiene un equipo de baloncesto?", "General", "Medio", "5", "6", "7", "11", "5"),

            // --- General: DIFÍCIL (10) ---
            Pregunta("¿Dios egipcio de la muerte?", "General", "Dificil", "Ra", "Horus", "Anubis", "Osiris", "Anubis"),
            Pregunta("¿Moneda de Suiza?", "General", "Dificil", "Euro", "Dólar", "Franco suizo", "Corona", "Franco suizo"),
            Pregunta("¿Nombre real de Buda?", "General", "Dificil", "Siddhartha Gautama", "Ghandi", "Dalai Lama", "Krishna", "Siddhartha Gautama"),
            Pregunta("¿Metal más caro del mundo (aprox)?", "General", "Dificil", "Oro", "Platino", "Rodio", "Paladio", "Rodio"),
            Pregunta("¿Cuántas casillas tiene un tablero de ajedrez?", "General", "Dificil", "60", "64", "68", "72", "64"),
            Pregunta("¿Cuántas cartas tiene una baraja de póker?", "General", "Dificil", "40", "48", "50", "52", "52"),
            Pregunta("¿Kilómetros de una maratón?", "General", "Dificil", "40 km", "42,195 km", "45 km", "50 km", "42,195 km"),
            Pregunta("¿Película con más Oscars (junto a Titanic)?", "General", "Dificil", "Avatar", "Star Wars", "Ben-Hur", "El Padrino", "Ben-Hur"),
            Pregunta("¿Dónde fueron los JJOO de 2020?", "General", "Dificil", "Río", "Londres", "Tokio", "París", "Tokio"),
            Pregunta("¿Cuánto es 10 en sistema binario?", "General", "Dificil", "10", "2", "4", "100", "2")
        )
    }
}