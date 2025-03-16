/*

    Autor: Piero De La Cruz Mancilla
    Fecha de creación: 16/03/2025
    Fecha de última modificación: 16/03/2025

    Piedra, Papel, Tijera. Escriba un programa que realice el juego de piedra, papel o tijera.
    La computadora debe elegir de manera aleatoria la opción a elegir.
    Después debe preguntar al usuario que opción quiere. Imprimir si ganó, perdió o empató.

*/

import kotlin.random.Random

fun jugarPiedraPapelTijera(jugador: String): String {
    val opciones = listOf("piedra", "papel", "tijera")
    val computadora = opciones[Random.nextInt(opciones.size)]

    println("La computadora eligió: $computadora")

    return when {
        jugador == computadora -> "Empate"
        (jugador == "piedra" && computadora == "tijera") ||
                (jugador == "papel" && computadora == "piedra") ||
                (jugador == "tijera" && computadora == "papel") -> "Ganaste"
        else -> "Perdiste"
    }
}

fun main() {
    println("¡Bienvenido a Piedra, Papel o Tijera!")
    println("Elige una opción: piedra, papel o tijera:")

    val eleccionJugador = readLine()?.lowercase() ?: ""

    if (eleccionJugador !in listOf("piedra", "papel", "tijera")) {
        println("Opción no válida. Por favor, elige piedra, papel o tijera.")
        return
    }

    val resultado = jugarPiedraPapelTijera(eleccionJugador)
    println(resultado)
}