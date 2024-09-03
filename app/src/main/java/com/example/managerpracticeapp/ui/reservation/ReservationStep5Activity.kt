package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.managerpracticeapp.R
import com.example.managerpracticeapp.databinding.ActivityReservationStep5Binding

class ReservationStep5Activity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStep5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationStep5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToPrevious()
        navigateToNext()
    }

    private fun navigateToPrevious() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.previousBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun navigateToNext() {
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, ReservationStep6Activity::class.java)
            startActivity(intent)
        }
    }


}