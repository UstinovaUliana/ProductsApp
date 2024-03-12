package com.example.productsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.productsapp.databinding.ItemProductBinding
import com.example.productsapp.model.ProductUI
import com.example.productsapp.util.ProductsDiffUtilItemCallback

class ProductsRecyclerAdapter(private val onClick: (ProductUI) -> Unit) :
    PagingDataAdapter<ProductUI, ProductsRecyclerAdapter.ProductsViewHolder>(
        ProductsDiffUtilItemCallback()
    ) {

    class ProductsViewHolder(
        private val binding: ItemProductBinding,
        val onClick: (ProductUI) -> Unit
    ) : ViewHolder(binding.root) {
        fun onBind(item: ProductUI) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(item.thumbnail)
                    .into(thumbnailView)
                titleTextView.text = item.title
                descriptionTextView.text = item.description
            }
            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(itemBinding, onClick)
    }
}