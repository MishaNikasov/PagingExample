package com.nikasov.pagingexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nikasov.pagingexample.R
import com.nikasov.pagingexample.databinding.ItemLoadStateBinding

class LoadStateViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.item_load_state, parent, false)
) {
    private val binding = ItemLoadStateBinding.bind(itemView)

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.errorMsg.isVisible = loadState is LoadState.Error
    }
}

class PassengerLoadStateAdapter : LoadStateAdapter<LoadStateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = LoadStateViewHolder(parent)
    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) = holder.bind(loadState)
}