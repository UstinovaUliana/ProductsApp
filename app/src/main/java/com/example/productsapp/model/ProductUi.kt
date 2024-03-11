package com.example.productsapp.model

import com.example.domain.models.Product
import com.example.productsapp.util.IBaseDiffModel

data class ProductUI(
    val thumbnail: String,
    override val title: String,
    val description: String,
    val price: Int,
    val rating: Float,
    val images: ArrayList<String>
) : IBaseDiffModel<String>, java.io.Serializable

fun Product.toUI() = ProductUI(
    thumbnail, title, description, price, rating, images
)
