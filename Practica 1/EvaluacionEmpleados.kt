/*

    Autor: Piero De La Cruz Mancilla
    Fecha de creación: 16/03/2025
    Fecha de última modificación: 16/03/2025

En una determinada empresa, sus empleados son evaluados cada seis meses.
Los puntos que pueden obtener en la evaluación comienzan en 0 y pueden
ir aumentando hasta llegar a 10, traduciéndose en mejores beneficios.
Al final del problema se muestra una tabla con los niveles correspondientes a cada puntuación.
La cantidad de dinero conseguida en cada nivel  se calcula multiplicando el salario mensual
por la  división de la puntuación del nivel divida entre 10. Escribir un programa que lea
la puntuación del usuario y su salario mensual e imprima su nivel de rendimiento,
así como la cantidad de dinero que recibirá el usuario.
Ejemplo:
Salario 10,000;
Puntuación 8.
Dinero = 10,000 * (8/10)= 8000.
Resultado: Nivel de Rendimiento Aceptable, Cantidad de Dinero Recibido $8000.


    -------------------------------
    |   Nivel        | Puntuación |
    -------------------------------
    | Inaceptable   |   0 - 3     |
    | Aceptable     |   4 - 6     |
    | Meritorio     |   7 - 10    |
    -------------------------------

*/

fun calcularRendimiento(puntuacion: Int, salario: Double): Pair<String, Double> {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable" to salario * (puntuacion / 10.0)
        in 4..6 -> "Aceptable" to salario * (puntuacion / 10.0)
        in 7..10 -> "Meritorio" to salario * (puntuacion / 10.0)
        else -> "Puntuación inválida" to 0.0
    }
}

fun main() {
    println("Ingrese la puntuación del empleado (0-10):")
    val puntuacion = readLine()?.toIntOrNull() ?: 0

    println("Ingrese el salario mensual del empleado:")
    val salario = readLine()?.toDoubleOrNull() ?: 0.0

    if (puntuacion !in 0..10) {
        println("Puntuación inválida. Debe estar entre 0 y 10.")
        return
    }

    val (nivel, dinero) = calcularRendimiento(puntuacion, salario)

    println("Nivel de Rendimiento: $nivel")
    println("Cantidad de Dinero Recibido: $${"%.2f".format(dinero)}")
}