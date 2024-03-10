package com.example.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.Product

class ProductPagingSource (private val service: ProductsApiService) : BasePagingSource<ProductDto, Product>( {

    service.loadProducts(it)

})