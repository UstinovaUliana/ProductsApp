package com.example.productsapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.productsapp.databinding.ItemProductBinding
import com.example.productsapp.model.ProductUI
import com.example.productsapp.util.MyDiffUtilItemCallback

class ProductsRecyclerAdapter(val context: Context) :
    PagingDataAdapter<ProductUI, ProductsRecyclerAdapter.ProductsViewHolder>(
        MyDiffUtilItemCallback()
    ) {

    class ProductsViewHolder(private val binding: ItemProductBinding) : ViewHolder(binding.root) {
        fun onBind(item: ProductUI) = with(binding) {
            Log.d("mytag", item.title)
            Glide.with(itemView.context)
                .load(item.thumbnail)
                .into(thumbnailView)
            titleTextView.text = item.title
            descriptionTextView.text = item.description
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
        return ProductsViewHolder(itemBinding)
    }
}