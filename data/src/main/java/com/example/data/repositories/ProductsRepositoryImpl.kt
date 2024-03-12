package com.example.data.repositories

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.rxjava2.flowable
import com.example.data.api.ProductsApiService
import com.example.data.paging.ProductPagingSource
import com.example.domain.repositories.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val service: ProductsApiService) :
    ProductsRepository {

    override fun loadProducts() = doPagingRequest(ProductPagingSource(service))

    private fun <Key : Any, Value : Any> doPagingRequest(
        pagingSource: PagingSource<Key, Value>,
        pageSize: Int = 20,
        prefetchDistance: Int = pageSize,
        enablePlaceholders: Boolean = true,
        initialLoadSize: Int = pageSize * 2,
        maxSize: Int = Int.MAX_VALUE,
        jumpThreshold: Int = Int.MIN_VALUE
    ): io.reactivex.Flowable<PagingData<Value>> {
        Log.d("mytag", "RepositoryImpl")
        return Pager(
            config = PagingConfig(
                pageSize,
                prefetchDistance,
                enablePlaceholders,
                initialLoadSize,
                maxSize,
                jumpThreshold
            ),
            pagingSourceFactory = {
                pagingSource
            }
        ).flowable
    }
}