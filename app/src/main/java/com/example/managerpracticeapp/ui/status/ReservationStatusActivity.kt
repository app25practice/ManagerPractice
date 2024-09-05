package com.example.managerpracticeapp.ui.status

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.managerpracticeapp.R
import com.example.managerpracticeapp.databinding.ActivityLiveCompanionBinding
import com.example.managerpracticeapp.databinding.ActivityReservationStatusBinding
import java.util.Date

class ReservationStatusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStatusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReservationStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToPrevious()
        setReservationStatusRecyclerViewAdapter()
        setReservationHistoryRecyclerViewAdapter()

    }

    private fun setReservationStatusRecyclerViewAdapter() {
        val adapter = ReservationStatusRecyclerViewAdapter()

        binding.resStatusRecyclerView.adapter = adapter
        binding.resStatusRecyclerView.layoutManager = LinearLayoutManager(this)

        //mock 테스트
        adapter.submitList(createMock())
    }


    private fun setReservationHistoryRecyclerViewAdapter(){
        val adapter = ReservationHistoryRecyclerViewAdapter()
        binding.resHistoryRecyclerView.adapter = adapter
        binding.resHistoryRecyclerView.layoutManager = LinearLayoutManager(this)

        //mock 테스트
        adapter.submitList(createMock())
    }

    private fun createMock(): List<ReservationInfo> = listOf(
        ReservationInfo(id = "1", name = "김지수", date = Date()),
        ReservationInfo(id = "2", name = "홍길동", date = Date())
    )

    private fun navigateToPrevious(){
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

}