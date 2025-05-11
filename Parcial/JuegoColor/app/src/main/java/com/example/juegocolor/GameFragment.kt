package com.example.juegocolor

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.juegocolor.databinding.FragmentGameBinding

/*
 * Archivo: GameFragment.kt
 * Autor: Piero De La Cruz
 * Fecha: 10/05/2025
 *
 * Descripción:
 * Fragmento donde se ejecuta la lógica del juego.
 * En este ejemplo se utiliza MediaPlayer para reproducir sonidos de acierto y error,
 * además de un CountDownTimer para limitar el tiempo de juego a 30 segundos.
 * Se emplea View Binding para acceder de forma segura a los elementos del layout.
 * La lista de colores se inicializa a partir de los recursos, y se valida la respuesta
 * del usuario comparando el color seleccionado con el color actual generado.
 */
class GameFragment : Fragment() {

    // Se utiliza View Binding para acceder de forma segura a los elementos del layout.
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    // Variables para puntaje y temporizador.
    private var score = 0
    private val totalTimeInMillis: Long = 30000 // 30 segundos
    private lateinit var countDownTimer: CountDownTimer

    // Lista de colores disponibles.
    // Se inicializará en onViewCreated ya que se requiere el context para obtener los recursos.
    private lateinit var colorList: List<Int>

    // Color actual que se muestra en pantalla.
    private var currentColor: Int = 0

    // MediaPlayers para reproducir sonidos de acierto y error.
    private lateinit var correctSound: MediaPlayer
    private lateinit var wrongSound: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa la lista de colores a partir de los recursos definidos en colors.xml.
        colorList = listOf(
            ContextCompat.getColor(requireContext(), R.color.red),
            ContextCompat.getColor(requireContext(), R.color.green),
            ContextCompat.getColor(requireContext(), R.color.blue),
            ContextCompat.getColor(requireContext(), R.color.yellow)
        )

        // Inicializa los sonidos desde la carpeta res/raw.
        correctSound = MediaPlayer.create(requireContext(), R.raw.correct_sound)
        wrongSound = MediaPlayer.create(requireContext(), R.raw.wrong_sound)

        // Actualiza el marcador inicial.
        binding.tvScore.text = getString(R.string.points_text, score)

        // Inicia el temporizador de 30 segundos.
        startTimer()

        // Genera el primer color.
        generateNewColor()

        // Configura los listeners para los botones de color.
        binding.btnRed.setOnClickListener {
            validateAnswer(ContextCompat.getColor(requireContext(), R.color.red))
        }
        binding.btnGreen.setOnClickListener {
            validateAnswer(ContextCompat.getColor(requireContext(), R.color.green))
        }
        binding.btnBlue.setOnClickListener {
            validateAnswer(ContextCompat.getColor(requireContext(), R.color.blue))
        }
        binding.btnYellow.setOnClickListener {
            validateAnswer(ContextCompat.getColor(requireContext(), R.color.yellow))
        }
    }

    /**
     * Genera un nuevo color aleatorio a partir de la lista y lo asigna
     * al View que muestra el color a adivinar.
     */
    private fun generateNewColor() {
        currentColor = colorList.random()
        binding.viewColorDisplay.setBackgroundColor(currentColor)
    }

    /**
     * Valida la respuesta escogida por el usuario.
     * Si acierta, incrementa el puntaje y reproduce el sonido correcto.
     * Si se equivoca, reproduce el sonido incorrecto.
     * Luego, actualiza el marcador, ejecuta una breve animación y genera un nuevo color.
     * getString(R.string.points_text, score)
     */
    private fun validateAnswer(selectedColor: Int) {
        if (selectedColor == currentColor) {
            score++
            binding.tvScore.text = getString(R.string.points_text, score)
            correctSound.start()
        } else {
            wrongSound.start()
        }

        // Anima la vista del color: una rotación breve para dar feedback visual.
        binding.viewColorDisplay.animate().apply {
            duration = 150
            rotationBy(360f)
        }.start()

        generateNewColor()
    }

    /**
     * Inicia un CountDownTimer por 30 segundos, actualizando la vista del temporizador
     * cada segundo. Al finalizar, se navega al ResultFragment pasando el puntaje obtenido.
     */
    private fun startTimer() {
        countDownTimer = object : CountDownTimer(totalTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                binding.tvTimer.text = "Tiempo: ${secondsLeft}s"
            }

            override fun onFinish() {
                // Al terminar el tiempo, navega a la pantalla de resultados con el puntaje final.
                val action = GameFragmentDirections.actionGameFragmentToResultFragment(score)
                findNavController().navigate(action)
            }
        }
        countDownTimer.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Cancelamos el temporizador y liberamos los recursos de audio para evitar fugas de memoria.
        countDownTimer.cancel()
        correctSound.release()
        wrongSound.release()
        _binding = null
    }
}
