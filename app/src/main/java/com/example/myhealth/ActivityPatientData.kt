package com.example.myhealth

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityPatientData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient_data)

        // Configuración de la ventana para Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener el Spinner para seleccionar el sexo
        val spinnerSexo: Spinner = findViewById(R.id.spinnerSexo) // Asegúrate de tener este Spinner en tu layout

        // Crear un ArrayAdapter usando el array de opciones definido en strings.xml
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.sexo_options, // Nombre del array en strings.xml
            android.R.layout.simple_spinner_item
        )

        // Especificar el layout para el dropdown del Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asignar el adaptador al Spinner
        spinnerSexo.adapter = adapter

        // Configurar el listener para detectar la selección
        spinnerSexo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedSexo = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@ActivityPatientData, "Sexo seleccionado: $selectedSexo", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada si no se selecciona nada
            }
        }
    }
}

