package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.managerpracticeapp.databinding.ActivityReservationStep6Binding
import com.example.managerpracticeapp.domain.HospitalDomain
import com.example.managerpracticeapp.ui.reservation.adapters.HospitalRecyclerViewAdapter
import com.example.managerpracticeapp.ui.reservation.interfaces.OnHospitalClickListener

class ReservationStep6Activity : AppCompatActivity() {
    lateinit var binding:ActivityReservationStep6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationStep6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSearchResultRecyclerView()
        navigateToPrevious()
    }

    private fun setSearchResultRecyclerView() {
        val hospitals = mutableListOf<HospitalDomain>()

        repeat(20) {
            hospitals.add(HospitalDomain("병원${it + 1}", "부산광역시 서구 구덕로 ${it + 170}"))
        }

        val hospitalClickListener =
            object : OnHospitalClickListener {
                override fun onHospitalClicked() {
                    val intent = Intent(this@ReservationStep6Activity, ReservationStep7Activity::class.java)
                    startActivity(intent)
                }

            }

        val adapter = HospitalRecyclerViewAdapter(hospitalClickListener)
        binding.hospitalRecyclerView.adapter = adapter
        binding.hospitalRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter.submitList(hospitals)

    }

    private fun navigateToPrevious() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}