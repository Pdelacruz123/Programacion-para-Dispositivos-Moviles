package com.example.juegocolor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juegocolor.databinding.FragmentResultBinding

/*
 * Archivo: ResultFragment.kt
 * Autor: Piero De La Cruz
 * Fecha: 10/05/2025
 *
 * Descripción:
 * Fragmento que muestra el resultado final del juego. Recibe el puntaje final a través de Safe Args,
 * muestra el puntaje y un mensaje de retroalimentación. Además, compara el puntaje actual con el
 * mejor puntaje almacenado en SharedPreferences y permite al usuario volver a jugar (navegando de
 * vuelta al fragmento de bienvenida).
 */
class ResultFragment : Fragment() {

    // Se utiliza View Binding para referenciar los elementos del layout.
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    // Variable para almacenar el puntaje final recibido.
    private var finalScore: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflamos el layout usando View Binding.
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Se obtiene el puntaje final enviado desde GameFragment a través de Safe Args.
        finalScore = arguments?.let { ResultFragmentArgs.fromBundle(it).score } ?: 0

        // Muestra el puntaje final en el TextView correspondiente.
        binding.tvFinalScore.text = "Tu puntaje: $finalScore"

        // Se accede a SharedPreferences para recuperar y comparar el mejor puntaje.
        val sharedPrefs = requireActivity().getSharedPreferences("JuegoColorPrefs", Context.MODE_PRIVATE)
        val bestScore = sharedPrefs.getInt("best_score", 0)
        if (finalScore > bestScore) {
            // Si se logra un nuevo récord, se almacena y se muestra un mensaje indicándolo.
            sharedPrefs.edit().putInt("best_score", finalScore).apply()
            binding.tvBestScore.text = "¡Nuevo récord: $finalScore!"
        } else {
            // Si no, se muestra el mejor puntaje guardado.
            binding.tvBestScore.text = "Mejor puntaje: $bestScore"
        }

        // Determina un mensaje de retroalimentación según el puntaje obtenido.
        val feedbackMessage = when {
            finalScore >= 20 -> "¡Excelente!"
            finalScore >= 10 -> "¡Muy bien!"
            else -> "¡Sigue practicando!"
        }
        binding.tvMessage.text = feedbackMessage

        // Configura el botón para volver a jugar: navega de vuelta al fragmento de bienvenida.
        binding.btnPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_welcomeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Libera la referencia del binding para evitar fugas de memoria.
        _binding = null
    }
}
