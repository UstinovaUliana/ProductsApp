package com.example.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun loadProducts(): Flow<PagingData<Product>>

}