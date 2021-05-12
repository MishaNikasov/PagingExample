package com.nikasov.pagingexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikasov.pagingexample.R
import com.nikasov.pagingexample.data.network.passenger.entity.PassengerEntity
import com.nikasov.pagingexample.databinding.ItemPassengerBinding
import javax.inject.Inject

class PassengerAdapter @Inject constructor() : PagingDataAdapter<PassengerEntity, PassengerAdapter.PassengerViewHolder>(PassengerDiffItemCallback) {

    inner class PassengerViewHolder(private val binding: ItemPassengerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(passengerEntity: PassengerEntity?) {
            passengerEntity?.let {
                binding.title.text = it.name
                binding.body.text = it._id
            }
        }
    }

    object PassengerDiffItemCallback : DiffUtil.ItemCallback<PassengerEntity>() {
        override fun areItemsTheSame(oldItem: PassengerEntity, newItem: PassengerEntity): Boolean {
            return (oldItem == newItem)
        }

        override fun areContentsTheSame(oldItem: PassengerEntity, newItem: PassengerEntity): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    override fun onBindViewHolder(holder: PassengerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassengerViewHolder {
        return PassengerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_passenger,
                parent,
                false
            )
        )
    }
}