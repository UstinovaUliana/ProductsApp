package com.example.domain.repositories

import androidx.paging.PagingData
import com.example.domain.models.Product
import io.reactivex.Flowable

interface ProductsRepository {

    fun loadProducts(): Flowable<PagingData<Product>>

    //fun searchProducts(): Flow<PagingData<Product>>

}