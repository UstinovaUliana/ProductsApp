package com.example.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApiService {

    @GET("products")
    suspend fun loadProducts (
        @Query("") page: Int
    ): Response<ProductPagingResponse<ProductDto>>
}