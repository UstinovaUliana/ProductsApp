package com.example.domain.usecase

import com.example.domain.repositories.ProductsRepository
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor (private val repository: ProductsRepository) {

    operator fun invoke() = repository.searchProducts()

}