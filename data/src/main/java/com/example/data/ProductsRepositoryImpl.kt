package com.example.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.Product
import com.example.domain.ProductsRepository
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val service: ProductsApiService): ProductsRepository {

    override fun loadProducts() = doPagingRequest(ProductPagingSource(service))

    protected fun <ProductDto : DataMapper<Product>, Product : Any> doPagingRequest(
        pagingSource: BasePagingSource<ProductDto, Product>,
        pageSize: Int = 10,
        prefetchDistance: Int = pageSize,
        enablePlaceholders: Boolean = true,
        initialLoadSize: Int = pageSize * 3,
        maxSize: Int = Int.MAX_VALUE,
        jumpThreshold: Int = Int.MIN_VALUE
    ): Flow<PagingData<Product>> {
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
        ).flow
    }


    private fun getProducts() = arrayListOf(
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
    )
}