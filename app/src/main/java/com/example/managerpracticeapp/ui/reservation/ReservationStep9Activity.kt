package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import android.view.View
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

        getManagerData()
        bottomSheetSet()
        navigateToMain()
        navigateToNext()

    }
    private fun bottomSheetSet(){
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomsheetManagerInfor)
        bottomSheetBehavior.peekHeight = 400
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }
    private fun navigateToMain() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
    private fun getManagerData() {
        val manager = intent.getParcelableExtra<Manager>("getManager")
        managerInforUpdate(manager!!)
    }

    private fun managerInforUpdate (manager: Manager){
        manager.let {
            binding.name.text = it.name

        }
    }

    private fun navigateToNext() {
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, ReservationCheckActivity::class.java).apply {

            }
            startActivity(intent)
        }
    }
}
