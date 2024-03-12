package com.example.data.api

import com.example.data.dtos.ProductPagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApiService {

    @GET("products")
    suspend fun loadProducts (
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): Response<ProductPagingResponse>

}