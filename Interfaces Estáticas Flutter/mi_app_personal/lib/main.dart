/*
Nombre: Piero De La Cruz Mancilla
Fecha: 27 de mayo de 2025
Descripción: Archivo principal de la aplicación Flutter. Configura la aplicación
y define cuál pantalla mostrar como pantalla inicial.
*/

import 'package:flutter/material.dart';
import 'pantalla_inicio.dart';
import 'pantalla_perfil.dart';
import 'pantalla_hobbies.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Mi App Personal',
      home: PantallaInicio(),
    );
  }
}