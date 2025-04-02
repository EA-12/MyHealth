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
        val adapterSexo = ArrayAdapter.createFromResource(
            this,
            R.array.sexo_options, // Nombre del array en strings.xml
            android.R.layout.simple_spinner_item
        )

        // Especificar el layout para el dropdown del Spinner
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asignar el adaptador al Spinner
        spinnerSexo.adapter = adapterSexo

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

        // Obtener los Spinners del layout
        val spinnerYear: Spinner = findViewById(R.id.spinnerYear)
        val spinnerMonth: Spinner = findViewById(R.id.spinnerMonth)
        val spinnerDay: Spinner = findViewById(R.id.spinnerDay)

        // Configurar el Spinner para el Año
        val yearAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.years_array,
            android.R.layout.simple_spinner_item
        )
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerYear.adapter = yearAdapter

        // Configurar el Spinner para el Mes
        val monthAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.months_array,
            android.R.layout.simple_spinner_item
        )
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMonth.adapter = monthAdapter

        // Configurar el Spinner para el Día
        val dayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.days_array,
            android.R.layout.simple_spinner_item
        )
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDay.adapter = dayAdapter

        // Configurar el listener para detectar las selecciones
        spinnerYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedYear = parentView?.getItemAtPosition(position).toString()
                Toast.makeText(this@ActivityPatientData, "Año seleccionado: $selectedYear", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // No hacer nada si no se selecciona nada
            }
        }

        spinnerMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedMonth = parentView?.getItemAtPosition(position).toString()
                Toast.makeText(this@ActivityPatientData, "Mes seleccionado: $selectedMonth", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // No hacer nada si no se selecciona nada
            }
        }

        spinnerDay.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedDay = parentView?.getItemAtPosition(position).toString()
                Toast.makeText(this@ActivityPatientData, "Día seleccionado: $selectedDay", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // No hacer nada si no se selecciona nada
            }
        }
    }
}

