package com.example.domain.models



data class Product(
    val thumbnail: String,
    val title: String,
    val description: String,
    val price: Int,
    val rating: Float,
    val images: ArrayList<String>
)
