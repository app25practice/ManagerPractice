package com.example.managerpracticeapp.ui.reservation

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
    }

    private fun navigateToPrevious() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.previousBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }


}