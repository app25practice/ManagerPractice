package com.example.managerpracticeapp.ui.reservation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.managerpracticeapp.Manager
import com.example.managerpracticeapp.databinding.ActivityReservationStep8Binding
import com.example.managerpracticeapp.domain.HospitalDomain
import com.example.managerpracticeapp.ui.reservation.adapters.HospitalRecyclerViewAdapter
import com.example.managerpracticeapp.ui.reservation.adapters.ManagerRecyclerViewAdapter
import com.example.managerpracticeapp.ui.reservation.interfaces.OnHospitalClickListener
import com.example.managerpracticeapp.ui.reservation.interfaces.OnManagerClickListener

class ReservationStep8Activity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStep8Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationStep8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setManagerRecyclerView()
        navigateToPrevious()
    }

    private fun setManagerRecyclerView() {
        val managerList: ArrayList<Manager> = getListFromDb()
        val managerClickListener =
            object : OnManagerClickListener {
                override fun onManagerClicked() {
                    val intent = Intent(this@ReservationStep8Activity, ReservationStep9Activity::class.java)
                    startActivity(intent)
                }

            }

        val adapter = ManagerRecyclerViewAdapter(managerClickListener)

        binding.managerRecyclerView.adapter = adapter
        binding.managerRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter.submitList(managerList)
    }

    private fun getListFromDb(): ArrayList<Manager> {
        val managerList: ArrayList<Manager> = arrayListOf(Manager("김지수"), Manager("임지수"),
            Manager("신지수"), Manager("이지수"), Manager("박지수")) // DB에서 데이터 받아옴
        return managerList
    }

    private fun navigateToPrevious() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
