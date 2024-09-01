package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.managerpracticeapp.R
import com.example.managerpracticeapp.databinding.ActivityReservationStep3Binding

class ReservationStep3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStep3Binding
    private var firstPhoneNum = "010"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationStep3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToPrevious()
        navigateToNext()
        setPhoneNumDropDown()
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
            val intent = Intent(this, ReservationStep4Activity::class.java)
            startActivity(intent)
        }
    }

    private fun setPhoneNumDropDown() {
        val phoneNumOptions = resources.getStringArray(R.array.phone_num_option)

        val arrayAdapter = ArrayAdapter(this, R.layout.item_dropdown, phoneNumOptions)
        binding.phoneNumAutoCompleteTextView.setAdapter(arrayAdapter)

        binding.phoneNumAutoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            firstPhoneNum = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "선택된 값: $firstPhoneNum", Toast.LENGTH_SHORT).show()
        }
    }

}