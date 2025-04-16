/**
 * Descripción: Actividad principal para el editor de perfil con confirmación
 * Autor: Piero Omar De La Cruz Mancilla
 * Fecha de creación: 16/04/2025
 * Última modificación: 16/04/2025
 */
package com.example.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio1.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioBinding

    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
            binding.etNombre.text?.clear()
            binding.etEdad.text?.clear()
            binding.etCiudad.text?.clear()
            binding.etCorreo.text?.clear()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState != null) {
            binding.etNombre.setText(savedInstanceState.getString(KEY_NOMBRE, ""))
            binding.etEdad.setText(savedInstanceState.getString(KEY_EDAD, ""))
            binding.etCiudad.setText(savedInstanceState.getString(KEY_CIUDAD, ""))
            binding.etCorreo.setText(savedInstanceState.getString(KEY_CORREO, ""))
        }

        binding.btnContinuar.setOnClickListener {

            val usuario = Usuario(
                nombre = binding.etNombre.text.toString(),
                edad = binding.etEdad.text.toString(),
                ciudad = binding.etCiudad.text.toString(),
                correo = binding.etCorreo.text.toString()
            )


            val intent = Intent(this, ResumenActivity::class.java).apply {
                putExtra(EXTRA_USUARIO, usuario)
            }
            activityResultLauncher.launch(intent)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NOMBRE, binding.etNombre.text.toString())
        outState.putString(KEY_EDAD, binding.etEdad.text.toString())
        outState.putString(KEY_CIUDAD, binding.etCiudad.text.toString())
        outState.putString(KEY_CORREO, binding.etCorreo.text.toString())
    }

    companion object {
        const val EXTRA_USUARIO = "extra_usuario"
        private const val KEY_NOMBRE = "nombre"
        private const val KEY_EDAD = "edad"
        private const val KEY_CIUDAD = "ciudad"
        private const val KEY_CORREO = "correo"
    }
}