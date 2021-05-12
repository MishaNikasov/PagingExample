package com.nikasov.pagingexample.ui.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import com.nikasov.pagingexample.R
import com.nikasov.pagingexample.data.network.entity.PostEntity
import com.nikasov.pagingexample.databinding.ItemPostBinding
import com.nikasov.pagingexample.ui.base.BaseAdapter
import javax.inject.Inject

class PostAdapter @Inject constructor(): BaseAdapter<PostEntity, ItemPostBinding>() {

    override var differ = AsyncListDiffer(this, callback)
    override var layoutId = R.layout.item_post

    override fun bind(binding: ItemPostBinding, model: PostEntity, position: Int) {
        binding.apply {
            title.text = model.title
            body.text = model.body
        }
    }

}