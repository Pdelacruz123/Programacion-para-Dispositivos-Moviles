// Descripción: Actividad para reproducir el audio seleccionado con controles
// de reproducción
// Autor: Kenny Luis Flores Chacón
// Fecha de creación: 21-09-2024
// Fecha de última modificación: 25-09-2024

package com.example.ejercicio2

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlayerActivity : AppCompatActivity() {

    private lateinit var albumImageView: ImageView
    private lateinit var audioNameTextView: TextView
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var backButton: Button
    private lateinit var seekBar: SeekBar
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        albumImageView = findViewById(R.id.album_image)
        audioNameTextView = findViewById(R.id.audio_name)
        playButton = findViewById(R.id.play_button)
        pauseButton = findViewById(R.id.pause_button)
        backButton = findViewById(R.id.back_button)
        seekBar = findViewById(R.id.seek_bar)

        val selectedAudio = intent.getIntExtra("selectedAudio", 0)
        val selectedImage = intent.getIntExtra("selectedImage", R.drawable.default_image)
        val audioName = intent.getStringExtra("audioName") ?: "Audio"

        // Asignar imagen y nombre del audio
        albumImageView.setImageResource(selectedImage)
        audioNameTextView.text = audioName

        // Array de archivos de audio en res/raw
        val audioFiles = arrayOf(
            R.raw.alan_walker_faded,
            R.raw.the_weeknd_blinding_lights,
            R.raw.the_weeknd_save_your_tears,
            R.raw.daddyyankee_con_calma,
            R.raw.ed_sheeran_shape_of_you
        )

        // Inicializar MediaPlayer con el archivo de audio seleccionado
        mediaPlayer = MediaPlayer.create(this, audioFiles[selectedAudio])

        seekBar.max = mediaPlayer?.duration ?: 0

        handler = Handler()

        runnable = Runnable {
            val currentPosition = mediaPlayer?.currentPosition ?: 0
            seekBar.progress = currentPosition
            handler.postDelayed(runnable, 1000)
        }
        // Botón de reproducción
        playButton.setOnClickListener {
            mediaPlayer?.start()
            handler.postDelayed(runnable, 0) // Actualizar la barra de progreso
        }

        // Botón de pausa
        pauseButton.setOnClickListener {
            mediaPlayer?.pause()
            handler.removeCallbacks(runnable) // Detener la actualización de la barra de progreso
        }
        // Cuando el usuario mueve la barra manualmente
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress) // Salta a la posición seleccionada
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        // Botón de volver
        backButton.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            handler.removeCallbacks(runnable) // Detener la actualización de la barra de progreso
           finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
        handler.removeCallbacks(runnable)
    }
}
