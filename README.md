
# 📱 Programación Para Dispositivos Móviles  
**Semestre:** VI — **🗓 Ciclo Académico:** 2025 - I  
**Profesor:** Josue Miguel Flores Parra  
**Autor:** Piero Omar De La Cruz Mancilla 🎓

---

## 🔰 Práctica 1: Introducción a Kotlin  
📁 [Ver en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/tree/main/Practica%201)

Aqui abordamos los fundamentos del lenguaje **Kotlin** mediante ejercicios de lógica básica, uso de condicionales, bucles, manejo de números aleatorios y operaciones matemáticas simples.

### 🔹 Ejercicios  

#### 1️⃣ Evaluación de empleados  
Una empresa evalúa el rendimiento de sus empleados asignando una puntuación de 0 a 10, lo cual determina un bono económico:

📌 **Fórmula:**  
`Dinero Extra = Salario × (Puntuación / 10)`

| Nivel        | Puntuación  |
|--------------|-------------|
| Inaceptable  | 0 - 3       |
| Aceptable    | 4 - 6       |
| Meritorio    | 7 - 10      |

📍 **Ejemplo:**  
**Entrada:** Salario: `10,000`, Puntuación: `8`  
**Salida:** Nivel: `Meritorio` — Bono: `$8,000`

🔗 [Código en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/blob/main/Practica%201/EvaluacionEmpleados.kt)

---

#### 2️⃣ Piedra, papel o tijeras  
Implementación del clásico juego contra la computadora.

📍 **Ejemplo:**  
**Usuario:** `Piedra`, **Computadora:** `Tijeras`  
**Resultado:** `¡Ganaste!`

🔗 [Código en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/blob/main/Practica%201/PiedraPapelTijeras.kt)

---

#### 3️⃣ Calculadora   
Menú interactivo con operaciones básicas.

📌 **Menú:**  
```
1. Suma  
2. Resta  
3. Multiplicación  
4. División  
5. Salir  
```

📍 **Ejemplo:**  
**Opción:** `1`, **Números:** `4 y 6`  
**Resultado:** `10`

🔗 [Código en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/blob/main/Practica%201/Calculadora.kt)

---

#### 4️⃣ Adivina el número  
Juego que genera un número entre **1 y 30**. El usuario tiene **5 intentos** para adivinarlo.

📍 **Ejemplo:**  
**Entrada:** `15`, **Número secreto:** `20`  
**Salida:** `El número es mayor. Intenta de nuevo.`

🔗 [Código en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/blob/main/Practica%201/AdivinarNumero.kt)

---

## 🧱 Práctica 2: Programación Orientada a Objetos en Kotlin  
📁 [Ver en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/tree/main/Practica%202)

Aplicación de conceptos POO como **clases, herencia, interfaces y encapsulamiento** en Kotlin.

### 🔹 Ejercicios

#### 1️⃣ Cuenta Bancaria  
Clase con validación de saldo, límite de retiro y operaciones básicas.

📍 **Ejemplo:**  
```
Saldo inicial: 5000  
Límite de retiro: 1000  
Monto: 1200 → ❌ No permitido  
Monto: 800 → ✅ Retiro exitoso. Saldo: 4200  
```

🔗 [Código en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/blob/main/Practica%202/Clase_Cuenta_Bancaria.kt)

---

#### 2️⃣ Producto  
Clase `Producto` con precio, descuento y cálculo del precio final.

📍 **Ejemplo:**  
```
Precio: 100  
Descuento: 15%  
Precio final: 85.0  
```

🔗 [Código en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/blob/main/Practica%202/Clase_Producto.kt)

---

#### 3️⃣ Figuras  
Jerarquía de clases con `Shape` como clase abstracta. Incluye `Cuadrado`, `Círculo` y `Rectángulo`.

📍 **Ejemplo:**  
```
Cuadrado de lado 4 → Área: 16, Perímetro: 16  
Círculo de radio 3 → Área: 28.27, Perímetro: 18.85  
```

🔗 [Código en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/blob/main/Practica%202/Clases_Figuras.kt)

---

#### 4️⃣ Sistema de Gestión de Biblioteca  
Sistema completo de biblioteca con clases, interfaces y operaciones de préstamo.

📍 **Estructura:**
- `Material` (abstracta)
- `Libro` y `Revista` (subclases)
- `Usuario` (data class)
- `IBiblioteca` (interfaz)
- `Biblioteca` (gestión de préstamo y devolución)

📍 **Ejemplo de uso:**  
```
Registrar libro → ✔  
Registrar usuario → ✔  
Prestar → Préstamo exitoso  
Devolver → ✔ Devolución registrada  
```

🔗 [Código en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/blob/main/Practica%202/Gestion_Biblioteca.kt)

---

## 🤖 Práctica 3: Aplicaciones Básicas Android  
📁 [Ver en GitHub](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/tree/main/Practica%203)

Desarrollo de apps Android sencillas que interactúan con imágenes y reproducen audio.

### 🔹 Ejercicios

#### 1️⃣ Interacción con Imágenes  
Mostrar un `Toast` al hacer clic en una imagen.

🔗 [Ejercicio 1](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/tree/main/Practica%203/Ejercicio%201)

---

#### 2️⃣ Reproductor de Música Básico  
App con botones para reproducir, pausar y detener un archivo de audio local.

🔗 [Ejercicio 2](https://github.com/Pdelacruz123/Programacion-para-Dispositivos-Moviles/tree/main/Practica%203/Ejercicio%202)

---
