package com.example.productsapp.model

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.Product
import com.example.productsapp.IBaseDiffModel

data class ProductUI(
    val thumbnail: String,
    override val title: String,
    val description: String
) : IBaseDiffModel<String>

fun Product.toUI() = ProductUI(
    thumbnail, title, description
)
