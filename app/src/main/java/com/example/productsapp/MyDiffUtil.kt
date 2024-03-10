package com.example.productsapp

import androidx.recyclerview.widget.DiffUtil


interface IBaseDiffModel<T> {
    val title: T
    override fun equals(other: Any?): Boolean
}

class MyDiffUtilItemCallback<T : IBaseDiffModel<S>, S> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}