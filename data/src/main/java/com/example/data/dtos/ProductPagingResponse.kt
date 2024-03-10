package com.example.data.dtos

import com.example.data.dtos.ProductDto
import com.google.gson.annotations.SerializedName

data class ProductPagingResponse (
    val products: List<ProductDto>?,
    val skip: Int,
    val limit: Int,
)