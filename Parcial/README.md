# JuegoColor

JuegoColor es una aplicación Android simple en la que el usuario debe acertar el color correcto. La aplicación utiliza el Navigation Component para gestionar la navegación entre diferentes fragmentos: una pantalla de bienvenida, la lógica del juego y la pantalla de resultados.

## Características

- **Pantalla de bienvenida**: Muestra el título, descripción y un botón para iniciar el juego.
- **Navegación**: Utiliza el Navigation Component para cambiar entre fragmentos.
- **View Binding**: Se utiliza para acceder de manera segura a los elementos del layout.

## Estructura del Proyecto

- **app/src/main/java/com/example/juegocolor/**
  - `WelcomeFragment.kt`: Fragmento de bienvenida.
  - `GameFragment.kt`: Fragmento donde se ejecuta la lógica del juego.
  - `ResultFragment.kt`: Fragmento que muestra los resultados y recibe, por ejemplo, el puntaje (score).

- **app/src/main/res/layout/**
  - `activity_main.xml`: Layout principal que contiene el NavHostFragment.
  - `fragment_welcome.xml`: Layout del WelcomeFragment.
  - `fragment_game.xml`: Layout del GameFragment.
  - `fragment_result.xml`: Layout del ResultFragment.
  - `nav_host_placeholder.xml`: Layout utilizado para la vista previa en el editor

- **app/src/main/res/navigation/**
  - `nav_graph.xml`: Define la navegación entre los fragmentos.

- **app/src/main/res/raw/**
  -correct_sound.mp3
  -wrong_sound.mp3

## Requisitos

- Android Studio (versión 4.2 o superior, se recomienda la última versión estable)
- Android Gradle Plugin 7.0+
- Kotlin


