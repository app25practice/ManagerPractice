package com.example.managerpracticeapp.ui.reservation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managerpracticeapp.databinding.ActivityReservationPaymentBinding

class ReservationPaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
