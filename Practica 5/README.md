# Práctica 5: Fragments y Navegación 🍔📱

Este proyecto corresponde a la **Práctica 5** del curso **Programación para Dispositivos Móviles**, donde se implementa un **configurador de pedidos de comida** utilizando **Fragments** y navegación entre ellos en Android Studio, con el lenguaje **Kotlin**.

## 🎯 Objetivo

Permitir al usuario armar un pedido paso a paso (selección de comida y extras) y visualizar un resumen final, aplicando el manejo de navegación entre fragments y paso de datos.

## 🧩 Fragments implementados

### 1. `InicioFragment`
- Muestra el botón **"Nuevo pedido"**.
- Navega a `SeleccionComidaFragment`.

### 2. `SeleccionComidaFragment`
- Permite elegir entre varios tipos de comida (Pizza, Hamburguesa, Ensalada).
- Al presionar **"Siguiente"**:
  - Se crea un `Bundle` con el tipo de comida.
  - Se navega a `SeleccionExtrasFragment`.

### 3. `SeleccionExtrasFragment`
- Permite seleccionar extras (bebida, papas, postre).
- Al presionar **"Siguiente"**:
  - Se agrega la información de los extras al mismo `Bundle` o uno nuevo.
  - Se navega a `ResumenPedidoFragment`.

### 4. `ResumenPedidoFragment`
- Muestra los datos del pedido usando `arguments?.getString(...)`, etc.
- Incluye botones:
  - **"Confirmar pedido"**: muestra un Toast y regresa al fragmento de inicio.
  - **"Editar pedido"**:
    - Usa `setFragmentResult()` para pasar datos de vuelta.
    - Usa `popBackStack()` para regresar a `SeleccionComidaFragment`, que recupera los datos con `setFragmentResultListener()`.

## 🧪 Conceptos prácticos aplicados

- Navegación entre fragments con `navigate()`.
- Paso de datos usando `Bundle`.
- Comunicación de datos hacia atrás con `setFragmentResult()` y `setFragmentResultListener()`.
- Uso de `popBackStack()` para navegación inversa.
- Uso opcional de **Safe Args** para mayor seguridad en el paso de argumentos.

## 🛠️ Requisitos

- Android Studio (recomendado: versión Hedgehog o superior)
- Lenguaje: Kotlin
- Módulo mínimo SDK: 21+

## 👤 Autor

- **Nombre:** Piero De La Cruz



---

> Cada archivo `.kt` incluye un encabezado con:
> - Descripción corta del problema
> - Autor
> - Fecha de creación
> - Fecha de última modificación
