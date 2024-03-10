package com.example.domain.repositories

import androidx.paging.PagingData
import com.example.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun loadProducts(): Flow<PagingData<Product>>

    fun searchProducts(): Flow<PagingData<Product>>

}