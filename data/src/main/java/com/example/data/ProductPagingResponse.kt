package com.example.data

import com.google.gson.annotations.SerializedName

class ProductPagingResponse<T> (
    @SerializedName("prev")
    val prev: Int?,
    @SerializedName("next")
    val next: Int?,
    @SerializedName("data")
    val data: MutableList<T>
)