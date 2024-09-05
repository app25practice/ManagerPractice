package com.example.managerpracticeapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managerpracticeapp.databinding.ActivityMainBinding
import com.example.managerpracticeapp.ui.companion.LiveCompanionActivity
import com.example.managerpracticeapp.ui.login.LoginEntryActivity
import com.example.managerpracticeapp.ui.reservation.ReservationStep1Activity
import com.example.managerpracticeapp.ui.status.ReservationStatusActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToReservation()
        navigateToLogin()
        navigateToLiveCompanion()
        navigateToReservationStatus()
    }

    private fun navigateToLogin() {
        binding.welcomeTextView.setOnClickListener {
            val intent = Intent(this, LoginEntryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToReservation() {
        binding.goReservationBtn.setOnClickListener {
            val intent = Intent(this, ReservationStep1Activity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToLiveCompanion() {
        binding.realTimeCompanionSeeAllBtn.setOnClickListener {
            val intent = Intent(this, LiveCompanionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToReservationStatus() {
        binding.reservationSeeAllBtn.setOnClickListener {
            val intent = Intent(this, ReservationStatusActivity::class.java)
            startActivity(intent)
        }
    }
}
