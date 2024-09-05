package com.example.managerpracticeapp.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.managerpracticeapp.Manager
import com.example.managerpracticeapp.databinding.ItemManagerBinding
import com.example.managerpracticeapp.ui.reservation.ReservationCheckActivity
import com.example.managerpracticeapp.ui.reservation.ReservationStep2Activity

class RecyclerViewMangerAdapter(val managerList: ArrayList<Manager>) : RecyclerView.Adapter<RecyclerViewMangerAdapter.ManagerListViewHolder>() {

    inner class ManagerListViewHolder(val binding: ItemManagerBinding) : RecyclerView.ViewHolder(binding.root){
        init{
            binding.root.setOnClickListener{
                val intent = Intent(binding.root.context, ReservationCheckActivity::class.java).apply {
                    putExtra("getManager",managerList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManagerListViewHolder {
        val binding = ItemManagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ManagerListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return managerList.count()
    }

    override fun onBindViewHolder(holder: ManagerListViewHolder, position: Int) {
        val manager = managerList[position]

        holder.binding.profileName.text = manager.name
        holder.binding.profileRating.text = manager.rating.toString()
        holder.binding.profileReviewCount.text = manager.reviewCount.toString()


    }
}