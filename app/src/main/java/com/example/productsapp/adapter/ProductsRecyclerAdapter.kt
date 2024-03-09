package com.example.productsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.productsapp.databinding.ItemProductBinding
import com.example.productsapp.model.Product

class ProductsRecyclerAdapter(val products: ArrayList<Product>, val context : Context) : Adapter<ProductsRecyclerAdapter.ProductsViewHolder>() {

    class ProductsViewHolder(binding: ItemProductBinding) : ViewHolder(binding.root) {
        val productThumbnail = binding.thumbnailView
        val productTitle = binding.titleTextView
        val productDescription = binding.descriptionTextView
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        products[position].also {
            Glide.with(holder.itemView.context)
                .load(it.thumbnail)
                .into(holder.productThumbnail)
            holder.productTitle.text = it.title
            holder.productDescription.text = it.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductsViewHolder(itemBinding)
    }
}