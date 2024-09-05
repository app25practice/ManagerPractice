package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.managerpracticeapp.databinding.ActivityReservationStep4Binding
import java.time.LocalDate
import java.time.format.DateTimeParseException

class ReservationStep4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStep4Binding
    private var date: LocalDate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationStep4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToPrevious()
        navigateToNext()
        setBirthdayTextChangedListener()
    }

    private fun setBirthdayTextChangedListener() {
        // 년도 입력 필드에 TextWatcher 추가
        binding.yearInput.addTextChangedListener { text ->
            updateDate()
            if (text?.length == 4) {
                binding.monthInput.requestFocus()
            }
        }

        // 월 입력 필드에 TextWatcher 추가
        binding.monthInput.addTextChangedListener { text ->
            updateDate()
            if (text?.length == 2) {
                binding.dayInput.requestFocus()
            }
        }

        // 일 입력 필드에 TextWatcher 추가
        binding.dayInput.addTextChangedListener { text ->
            updateDate()
        }
    }

    private fun updateDate() {
        val year = binding.yearInput.text.toString()
        val month = binding.monthInput.text.toString()
        val day = binding.dayInput.text.toString()

        if (year.length == 4 && month.isNotEmpty() && day.isNotEmpty()) {
            try {
                date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
                println("Selected date: $date")
            } catch (e: DateTimeParseException) {
                e.printStackTrace()
            }
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
            val intent = Intent(this, ReservationStep5Activity::class.java)
            startActivity(intent)
        }
    }
}
