// Descripción: Clase Producto que gestiona el descuento  y el precio
// Autor: Piero Omar De La Cruz Mancilla
// Fecha creación: 23/02/2025
// Fecha última modificación: 23/03/2025


class Producto(precio: Double, descuento: Double) {
    var precio: Double = precio
        set(value) {
            require(value >= 0) { "El precio no puede ser negativo" }
            field = value
        }

    var descuento: Double = descuento
        set(value) {
            require(value in 0.0..100.0) { "El descuento debe estar entre 0 y 100" }
            field = value
        }

    init {
        this.precio = precio
        this.descuento = descuento
    }

    fun calcularPrecioFinal(): Double {
        return precio * (1 - descuento / 100)
    }
}

fun main() {
    val producto = Producto(100.0, 15.0)
    println("Precio original: ${producto.precio}")
    println("Descuento: ${producto.descuento}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")
}
