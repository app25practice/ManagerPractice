package com.example.managerpracticeapp.ui.reservation.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.managerpracticeapp.Manager
import com.example.managerpracticeapp.databinding.ItemHospitalBinding
import com.example.managerpracticeapp.databinding.ItemManagerBinding
import com.example.managerpracticeapp.domain.HospitalDomain
import com.example.managerpracticeapp.ui.reservation.ReservationCheckActivity
import com.example.managerpracticeapp.ui.reservation.interfaces.OnHospitalClickListener
import com.example.managerpracticeapp.ui.reservation.interfaces.OnManagerClickListener

class ManagerRecyclerViewAdapter(private val clickListener: OnManagerClickListener) :
    ListAdapter<Manager, ManagerRecyclerViewAdapter.ManagerViewHolder>(ManagerDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ManagerViewHolder {
        val binding = ItemManagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ManagerViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(
        holder: ManagerViewHolder,
        position: Int,
    ) {
        val manager = getItem(position)
        holder.bind(manager)
    }

    class ManagerViewHolder(
        private val binding: ItemManagerBinding,
        private val clickListener: OnManagerClickListener,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var selectedManager: Manager

        init {
            itemView.setOnClickListener {
                clickListener.onManagerClicked()
            }
        }

        fun bind(manager: Manager) {
            binding.profileName.text = manager.name
        }
    }

    private class ManagerDiffCallback : DiffUtil.ItemCallback<Manager>() {
        override fun areItemsTheSame(
            oldItem: Manager,
            newItem: Manager,
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Manager,
            newItem: Manager,
        ): Boolean {
            return oldItem == newItem
        }
    }
}
