// Descripción: Clases para calcular propiedades de figuras
// Autor: Piero Omar De La Cruz Mancilla
// Fecha creación: 23/02/2025
// Fecha última modificación: 23/03/2025
import kotlin.math.PI
import kotlin.math.pow

abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}

class Cuadrado(val lado: Double) : Shape() {
    override val area: Double = calcularArea()
    override val perimetro: Double = calcularPerimetro()

    override fun calcularArea(): Double = lado.pow(2)
    override fun calcularPerimetro(): Double = 4 * lado
}

class Rectangulo(val base: Double, val altura: Double) : Shape() {
    override val area: Double = calcularArea()
    override val perimetro: Double = calcularPerimetro()

    override fun calcularArea(): Double = base * altura
    override fun calcularPerimetro(): Double = 2 * (base + altura)
}

class Circulo(val radio: Double) : Shape() {
    override val area: Double = calcularArea()
    override val perimetro: Double = calcularPerimetro()

    override fun calcularArea(): Double = PI * radio.pow(2)
    override fun calcularPerimetro(): Double = 2 * PI * radio
}

fun main() {
    val cuadrado = Cuadrado(5.0)
    println("Cuadrado:")
    cuadrado.imprimirResultados()

    val rectangulo = Rectangulo(4.0, 6.0)
    println("\nRectángulo:")
    rectangulo.imprimirResultados()

    val circulo = Circulo(3.0)
    println("\nCírculo:")
    circulo.imprimirResultados()
}
