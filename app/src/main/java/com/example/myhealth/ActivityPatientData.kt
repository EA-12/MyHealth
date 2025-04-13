package com.example.myhealth

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.*

class ActivityPatientData : AppCompatActivity() {

    private lateinit var editTextDate: EditText
    private val calendar = Calendar.getInstance()

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient_data)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener el Spinner para seleccionar el sexo
        val spinnerSexo: Spinner = findViewById(R.id.spinnerSex) // Asegúrate de tener este Spinner en tu layout

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
        spinnerSexo.setSelection(2)
        spinnerSexo.isEnabled = false
        spinnerSexo.isClickable = false
        spinnerSexo.isFocusable = false

        editTextDate = findViewById(R.id.editTextDate)

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 44)
        calendar.set(Calendar.MONTH, Calendar.JULY)
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateLabel()
        }

        editTextDate.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        updateLabel()

        val botonEditar = findViewById<Button>(R.id.buttonEdit)
        val botonGuardar = findViewById<Button>(R.id.buttonSave)

        val campos = listOf<EditText>(
            findViewById(R.id.editTextName),
            findViewById(R.id.editTextSurname),
            findViewById(R.id.editTextID),
            findViewById(R.id.editTextTlf),
            findViewById(R.id.editTextDate),
            findViewById(R.id.editTextCountry),
            findViewById(R.id.editTextPostalCode),
            findViewById(R.id.editTextAddress)
        )

        botonEditar.setOnClickListener {
            for (campo in campos) campo.isEnabled = true
            spinnerSexo.isEnabled = true
        }

        botonGuardar.setOnClickListener {
            for (campo in campos) campo.isEnabled = false
            spinnerSexo.isEnabled = false
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateLabel() {
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        editTextDate.setText(format.format(calendar.time))
    }

    fun goToHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

