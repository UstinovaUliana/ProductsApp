package com.example.data

import com.example.domain.Product
import com.google.gson.annotations.SerializedName

class ProductDto (
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String
    ) :DataMapper<Product> {
    override fun mapToDomain() = Product(thumbnail,title, description)
}