class CuentaBancaria(
    private var saldo: Double = 0.0,
    private var limiteRetiro: Double = 1000.0
) {
    // Getter para saldo
    fun getSaldo(): Double {
        return saldo
    }

    // Setter para saldo con validación
    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo < 0) {
            throw IllegalArgumentException("El saldo no puede ser negativo")
        }
        saldo = nuevoSaldo
    }

    // Getter para límite de retiro
    fun getLimiteRetiro(): Double {
        return limiteRetiro
    }

    // Setter para límite de retiro con validación
    fun setLimiteRetiro(nuevoLimite: Double) {
        if (nuevoLimite < 0) {
            throw IllegalArgumentException("El límite de retiro no puede ser negativo")
        }
        limiteRetiro = nuevoLimite
    }

    // Método para retirar dinero
    fun retirar(monto: Double): Double {
        if (monto > limiteRetiro) {
            throw IllegalArgumentException("El monto excede el límite de retiro")
        }
        if (monto > saldo) {
            throw IllegalArgumentException("Fondos insuficientes")
        }
        saldo -= monto
        return saldo
    }
}

// Ejemplo de uso
fun main() {
    val cuenta = CuentaBancaria(saldo = 2000.0, limiteRetiro = 500.0)
    println(cuenta.retirar(300.0)) // 1700.0
}