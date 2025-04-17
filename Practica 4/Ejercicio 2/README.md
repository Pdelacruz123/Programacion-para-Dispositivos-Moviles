# 🎯 Práctica: Editor de Notas con Comunicación entre Actividades

Este proyecto Android demuestra la comunicación básica entre actividades mediante un editor de notas simple que permite crear y compartir texto.

## 📱 Estructura de la aplicación

### 📝 Actividad 1 – EditorActivity
Pantalla principal para editar notas:
- Campo de texto (`EditText`) para escribir la nota
- Botón "Compartir" que envía el texto a la segunda actividad
- Implementa `onSaveInstanceState()` para conservar el texto en caso de rotación

### 📄 Actividad 2 – OpcionesActivity
Muestra la nota recibida y ofrece opciones:
- Muestra el texto de la nota en un `TextView`
- Botón "Compartir por correo" (muestra un `Toast` con mensaje "Compartido por correo")
- Botón "Editar de nuevo" (retorna a la actividad anterior conservando el texto)



## 🛠️ Requisitos

- Android Studio Iguana o superior
- SDK mínimo: API 24 (Android 7.0)
- SDK objetivo: API 35

