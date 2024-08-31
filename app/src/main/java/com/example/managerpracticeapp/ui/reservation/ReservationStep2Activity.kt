package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.managerpracticeapp.R
import com.example.managerpracticeapp.databinding.ActivityReservationStep2Binding

class ReservationStep2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStep2Binding
    private var relation = "본인"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReservationStep2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setRelationDropDown()
        navigateToPrevious()
        navigateToNext()
    }

    private fun setRelationDropDown() {
        val relationOptions = resources.getStringArray(R.array.relation_option)

        val arrayAdapter = ArrayAdapter(this, R.layout.item_dropdown, relationOptions)
        binding.relationAutoCompleteTextView.setAdapter(arrayAdapter)

        binding.relationAutoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            relation = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "선택된 값: $relation", Toast.LENGTH_SHORT).show()
        }
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
            val intent = Intent(this, ReservationStep3Activity::class.java)
            startActivity(intent)
        }
    }

}