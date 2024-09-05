package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managerpracticeapp.Manager
import com.example.managerpracticeapp.databinding.ActivityReservationStep9Binding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ReservationStep9Activity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStep9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationStep9Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        getManagerData()
        binding.name.text = "김지수"
        navigateToMain()
        navigateToNext()
        navigateToPrevious()
    }



    private fun navigateToMain() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

//    private fun getManagerData() {
//        val manager = intent.getParcelableExtra<Manager>("getManager")
//        managerInforUpdate(manager!!)
//    }

    private fun managerInforUpdate(manager: Manager) {
        manager.let {
            binding.name.text = it.name
        }
    }

    private fun navigateToNext() {
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this@ReservationStep9Activity, ReservationCheckActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToPrevious() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
