package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managerpracticeapp.databinding.ActivityReservationCheckBinding

class ReservationCheckActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToMain()
        navigateToNext()

    }
    private fun navigateToMain() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun navigateToNext() {
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, ReservationPaymentActivity::class.java)
            startActivity(intent)
        }
    }
}
