# 🧠 Práctica: Comunicación entre Actividades en Android

Este proyecto Android contiene dos actividades: un formulario para ingresar datos de usuario y una pantalla resumen donde se confirman o editan dichos datos.

## 📱 Estructura de la aplicación

### 📝 Actividad 1 – FormularioActivity
Formulario con los siguientes campos:
- Nombre
- Edad
- Ciudad
- Correo electrónico

📍 Incluye un botón:  
- `Continuar`: Envía los datos a la segunda actividad usando un `Intent` con una clase `Usuario` que implementa `Parcelable`.

🌀 También implementa `onSaveInstanceState()` para conservar los datos en caso de rotación de pantalla.

### 📄 Actividad 2 – ResumenActivity
Muestra un resumen de los datos recibidos con `TextView`.

Incluye dos botones:
- `Confirmar`: Vuelve a la primera actividad y muestra un `Toast` con el mensaje: **"Perfil guardado correctamente"**.
- `Volver a editar`: Retorna a la actividad anterior para modificar los datos.



## 🧩 Estructura de datos

```kotlin
@Parcelize
data class Usuario(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val correo: String
) : Parcelable
