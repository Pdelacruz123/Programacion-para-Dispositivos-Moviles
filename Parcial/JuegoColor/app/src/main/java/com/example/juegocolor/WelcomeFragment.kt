/*
 * Archivo: WelcomeFragment.kt
 * Autor: Piero De La Cruz Mancilla
 * Fecha: 10/05/2025
 *
 * Descripción:
 * Este fragmento representa la pantalla de bienvenida de la aplicación JuegoColor.
 * Muestra un título y una descripción atractiva, junto con un botón que permite
 * iniciar el juego. Al presionar el botón, se ejecuta la navegación hacia el GameFragment,
 * utilizando el Navigation Component. Se implementa View Binding para acceder de forma segura
 * a los elementos del layout.
 */

package com.example.juegocolor

import android.util.Log
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.juegocolor.databinding.FragmentWelcomeBinding

/**
 * Fragmento de bienvenida que muestra el título, la descripción y un botón para iniciar el juego.
 */
class WelcomeFragment : Fragment() {


    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartGame.setOnClickListener {

            Log.d("WelcomeFragment", "Botón presionado: iniciando navegación.")
            findNavController().navigate(R.id.action_welcomeFragment_to_gameFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
