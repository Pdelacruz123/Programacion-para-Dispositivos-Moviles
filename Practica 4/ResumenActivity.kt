/**
 * Descripción: Actividad para mostrar resumen de datos del perfil y confirmar
 * Autor: Piero Omar De La Cruz Mancilla
 * Fecha de creación: 16/04/2025
 * Última modificación: 16/04/2025
 */
package com.example.ejercicio1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio1.databinding.ActivityResumenBinding

class ResumenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResumenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar los datos del usuario
        val usuario = intent.getParcelableExtra<Usuario>(FormularioActivity.EXTRA_USUARIO)

        usuario?.let {
            binding.tvNombre.text = it.nombre
            binding.tvEdad.text = it.edad
            binding.tvCiudad.text = it.ciudad
            binding.tvCorreo.text = it.correo
        }


        binding.btnVolver.setOnClickListener {
            finish()
        }

        binding.btnConfirmar.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}