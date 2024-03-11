package com.example.data.dtos

import com.example.data.utils.DataMapper
import com.example.domain.models.Product
import com.google.gson.annotations.SerializedName

class ProductDto (
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("images")
    val images: ArrayList<String>
    ) : DataMapper<Product> {

    override fun mapToDomain() = Product(thumbnail,title, description, price, rating, images)
}