// Descripción: Actividad principal con spinner para seleccionar imágenes y un botón para pasar a la siguiente actividad
// Autor: Piero Omar De La Cruz
// Fecha de creación: 30/03/2025
// Fecha de última modificación: 30/03/2025

package com.example.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.image_spinner)
        nextButton = findViewById(R.id.next_button)

        val imageNames = arrayOf(
            getString(R.string.image_1),
            getString(R.string.image_2),
            getString(R.string.image_3)
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        nextButton.setOnClickListener {
            val selectedImage = spinner.selectedItemPosition
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("selectedImage", selectedImage)
            startActivity(intent)
        }

        if (savedInstanceState != null) {
            spinner.setSelection(savedInstanceState.getInt("spinnerPosition"))
        }
    }
 //Función para guardar la instancia
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("spinnerPosition", spinner.selectedItemPosition)
    }
}
