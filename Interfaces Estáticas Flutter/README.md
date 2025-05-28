# 📱 Mi App Personal - Flutter

Una aplicación personal desarrollada en Flutter que presenta tres interfaces estáticas para mostrar información personal, perfil y hobbies.

## 📋 Descripción

Esta aplicación fue creada como práctica para aprender el uso de widgets básicos de Flutter. Incluye tres pantallas principales sin navegación entre ellas, enfocándose en el diseño y estructura visual.

## 🎯 Objetivo

Practicar el uso de widgets fundamentales de Flutter como:

- `Text`
- `Image`
- `Column` y `Row`
- `Padding`
- `Container`
- `Scaffold`
- `AppBar`

## 🗂️ Estructura del Proyecto

```
lib/
├── main.dart              # Archivo principal de la aplicación
├── pantalla_inicio.dart   # Pantalla de bienvenida
├── pantalla_perfil.dart   # Pantalla de perfil personal
└── pantalla_hobbies.dart  # Pantalla de hobbies e intereses
```

## 🟦 Pantallas Incluidas

### 1. Pantalla de Inicio (Bienvenida)

- AppBar con título "Bienvenido"
- Mensaje de bienvenida personalizado
- Botón "Ver mi perfil"

### 2. Pantalla de Perfil Personal

- Imagen de perfil
- Nombre y descripción personal
- Información de contacto con íconos
- Email y teléfono

### 3. Pantalla de Hobbies

- Lista de 4 hobbies principales:
  - 💻 Programación
  - 🎮 Videojuegos
  - 🎵 Música
  - 📚 Lectura
- Cada hobby incluye ícono y descripción

## 🚀 Cómo Ejecutar

### Prerrequisitos

- Flutter SDK instalado
- Editor de código (VS Code, Android Studio)
- Emulador o dispositivo físico

### Pasos

1. Clona este repositorio
2. Navega a la carpeta del proyecto:
   ```bash
   cd mi_app_personal
   ```
3. Instala las dependencias:
   ```bash
   flutter pub get
   ```
4. Ejecuta la aplicación:
   ```bash
   flutter run
   ```

## 🔧 Cambiar entre Pantallas

Para probar cada pantalla individualmente, modificamos la línea en `main.dart`:

```dart
// Para pantalla de inicio
home: PantallaInicio(),

// Para pantalla de perfil
home: PantallaPerfil(),

// Para pantalla de hobbies
home: PantallaHobbies(),
```

## 🎨 Características de Diseño

- **Colores temáticos** por pantalla
- **Íconos representativos** para cada sección
- **Diseño responsive** y centrado
- **Tipografía personalizada** con diferentes tamaños y pesos
- **Contenedores con bordes redondeados** y sombras sutiles

## 🔮 Futuras Mejoras

- [ ] Navegación entre pantallas
- [ ] Animaciones de transición
- [ ] Formularios interactivos
- [ ] Base de datos local
- [ ] Temas claro/oscuro

---
