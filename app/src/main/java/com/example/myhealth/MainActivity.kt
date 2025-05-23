package com.example.myhealth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun goToPatientData(view: View) {
        val intent = Intent(this, ActivityPatientData::class.java)
        startActivity(intent)
    }
    fun goToBookAppointment(view: View) {
        val intent = Intent(this, ActivityBookAppointment::class.java)
        startActivity(intent)
    }
    fun goToMedicalHistory(view: View) {
        val intent = Intent(this, ActivityMedicalHistory::class.java)
        startActivity(intent)
    }
    fun goToServices(view: View) {
        val intent = Intent(this, ActivityServices::class.java)
        startActivity(intent)
    }
    fun goToMainActivity(view: View) {}
}


