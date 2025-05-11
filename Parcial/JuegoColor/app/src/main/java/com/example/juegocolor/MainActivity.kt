
/*
 * Archivo: MainActivity.kt
 * Autor: Piero De La Cruz Mancilla
 * Fecha: 10/05/2025
 *
 * Descripción:
 * Actividad principal de la aplicación JuegoColor implementada.
 * Configura el tema de la aplicación, el NavController y define la navegación entre las pantallas:
 * - WelcomeScreen: Pantalla de bienvenida.
 * - GameScreen: Pantalla donde se desarrolla la lógica del juego.
 * - ResultScreen: Pantalla que muestra el resultado (puntaje) y permite reiniciar el juego.
 *
 */

package com.example.juegocolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.juegocolor.ui.theme.JuegoColorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Configuración para pantallas edge-to-edge.
        setContent {
            JuegoColorTheme {
                // Creamos el NavController que manejará la navegación entre screens.
                val navController = rememberNavController()

                // Usamos Scaffold para manejar un layout general (por ejemplo, para incluir barras, etc.)
                Scaffold { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(
                            navController = navController,
                            startDestination = "welcome" // Pantalla de inicio de la aplicación.
                        ) {
                            // Pantalla de bienvenida.
                            composable("welcome") {
                                WelcomeScreen(
                                    onStartGame = {
                                        // Navega hacia la pantalla del juego cuando se inicie.
                                        navController.navigate("game")
                                    }
                                )
                            }
                            // Pantalla del juego.
                            composable("game") {
                                GameScreen(
                                    onGameEnd = { score ->
                                        // Cuando el juego termine, navega a la pantalla de resultados pasando el puntaje.
                                        navController.navigate("result/$score")
                                    }
                                )
                            }
                            // Pantalla de resultado, donde se recibe el puntaje como argumento.
                            composable(
                                route = "result/{score}",
                                arguments = listOf(navArgument("score") {
                                    type = NavType.IntType
                                })
                            ) { backStackEntry ->
                                // Extraemos el puntaje de los argumentos.
                                val score = backStackEntry.arguments?.getInt("score") ?: 0
                                ResultScreen(
                                    score = score,
                                    onPlayAgain = {
                                        // Al presionar "volver a jugar", regresamos a la pantalla de bienvenida.
                                        navController.popBackStack("welcome", inclusive = false)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// --- Composables de Pantallas ---

@Composable
fun WelcomeScreen(onStartGame: () -> Unit) {
    // Ejemplo de interfaz para la pantalla de bienvenida.
    Text(
        text = "Bienvenido a JuegoColor\nPresiona para iniciar el juego.",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun GameScreen(onGameEnd: (Int) -> Unit) {
    // Ejemplo de interfaz de la pantalla del juego.
    Text(
        text = "Pantalla del Juego\n[Implementar la lógica del juego aquí]",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ResultScreen(score: Int, onPlayAgain: () -> Unit) {
    // Ejemplo de interfaz para la pantalla de resultados.
    Text(
        text = "Resultado: $score\nPresiona para jugar de nuevo.",
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JuegoColorTheme {
        WelcomeScreen(onStartGame = {})
    }
}
