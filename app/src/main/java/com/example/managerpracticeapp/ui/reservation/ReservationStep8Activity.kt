package com.example.managerpracticeapp.ui.reservation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managerpracticeapp.Manager
import com.example.managerpracticeapp.databinding.ActivityReservationStep8Binding
import com.example.managerpracticeapp.ui.adapter.RecyclerViewMangerAdapter

class ReservationStep8Activity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStep8Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationStep8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        createRecyclerView()


    }
    private fun createRecyclerView(){
        val managerList : ArrayList<Manager> = getListFromDb()
        val adapter = RecyclerViewMangerAdapter(managerList)

    }
    private fun getListFromDb(): ArrayList<Manager> {
        val managerList : ArrayList<Manager> = ()  // DB에서 데이터 받아옴
        return managerList
    }
    }
