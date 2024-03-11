package com.example.productsapp.adapter

import android.content.Context
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

    class ProductsViewHolder(private val binding: ItemProductBinding, val onClickListener1: OnClickListener?) : ViewHolder(binding.root) {
        fun onBind(item: ProductUI){
            with(binding) {
                Glide.with(itemView.context)
                    .load(item.thumbnail)
                    .into(thumbnailView)
                titleTextView.text = item.title
                descriptionTextView.text = item.description
            }
            itemView.setOnClickListener{
                if (onClickListener1 != null) {
                    onClickListener1!!.onClick(position, item)
                }
            }
        }
    }

    lateinit var onClickListener1: OnClickListener

    interface OnClickListener {
        fun onClick(position: Int, model: ProductUI)
    }

    fun setOnClickListener(onClickListenerParam: OnClickListener) {
        this.onClickListener1 = onClickListenerParam
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(itemBinding, onClickListener1)
    }
}